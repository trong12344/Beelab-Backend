package com.Beelab.Imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.Beelab.Common.Paginated;
import com.Beelab.Entity.*;
import com.Beelab.Enum.OrderStatus;
import com.Beelab.Service.OrderServ;
import com.Beelab.config.ICurrentUserService;
import com.Beelab.dto.orderdto.*;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import com.Beelab.Common.HandleResponse;
import com.Beelab.DAO.OrderDAO;
import com.Beelab.DAO.OrderDetailDAO;
import com.Beelab.DAO.ProductDAO;
import com.Beelab.DAO.ProductDetailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderServ {
    @Autowired
    ProductDetailDAO pddao;
    @Autowired
    OrderDAO odao;
    @Autowired
    OrderDetailDAO oddao;

    private final ICurrentUserService currentUserService;
    private final ModelMapper mapper;


    @Override
    public HandleResponse<Order> create(CreateOrderDto createOrderDto) {
        List<ProductDetail> ListBuyedProduct = pddao.findAllByListofProductDetailId(createOrderDto.getOrderItems().stream().map(OrderItem::getProductDetailId).toList());
        Map<Integer, Integer> productDetailIdtoquantity = createOrderDto.getOrderItems().stream().collect(
                Collectors.toMap(OrderItem::getProductDetailId, OrderItem::getQuantity));

        Map<Integer, Double> productDetailToFinalPrice = new HashMap<>();
        double totalPrice = ListBuyedProduct.stream().mapToDouble(ProductDetail -> {
            int quantity = productDetailIdtoquantity.get(ProductDetail.getId());
            productDetailToFinalPrice.put(ProductDetail.getId(), ProductDetail.getProduct().getFinalPrice());
            return ProductDetail.getProduct().getFinalPrice() * quantity;
        }).sum();

        Order order = Order.builder()
                .address(createOrderDto.getAddress())
                .userName(createOrderDto.getCustomerName())
                .userPhoneNumber(createOrderDto.getPhoneNumber())
                .userEmail(createOrderDto.getEmail())
                .user((User) currentUserService.getCurrentUser().orElse(null))
                .totalAmount(totalPrice)
                .build();
        odao.save(order);

        productDetailIdtoquantity.forEach((productDetaildId, quantity) -> {
            OrderDetail orderDetail = OrderDetail.builder()
                    .order_id(order.getId())
                    .productDetailId(productDetaildId)
                    .quantity(quantity)
                    .price(productDetailToFinalPrice.get(productDetaildId))
                    .build();
            oddao.save(orderDetail);
            ProductDetail productDetail = pddao.findById(productDetaildId).orElseThrow();
            if (productDetail.getQuantity() < quantity) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Số lượng sản phẩm" + productDetail.getProduct().getName() + "không đủ");

            }
            productDetail.setQuantity(productDetail.getQuantity() - quantity);
            productDetail.setSold_quantity(productDetail.getSold_quantity() + quantity);
            pddao.save(productDetail);
        });

        return HandleResponse.ok(order);
    }

    @Override
    public HandleResponse<Paginated<Order>> getAllOrder(getAllOrderDto getAllOrderDto) {
        String sortField = getAllOrderDto.getSortField();
        if (sortField.isBlank()) {
            sortField = "id";
        }
        Page<Order> order = odao.getAll(getAllOrderDto.getPageable(sortField));
        return HandleResponse.ok(Paginated.of(order));
    }

    @Override
    public HandleResponse<List<OrderDetail>> getDetailByOderId(Integer oderId) {
        List<OrderDetail> orderDetail = oddao.findByOrderId(oderId);
        if (orderDetail.isEmpty()) {
            return HandleResponse.error("Không tìm thấy hóa đơn");
        }
        return HandleResponse.ok(orderDetail);
    }

    @Override
    public HandleResponse<Order> updateStatusOrder(UpdateStatusOrderDto updateStatusOrderDto) {
        Order order = odao.findById(updateStatusOrderDto.getOrderId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Không tìm thấy hóa đơn"));
        if (order.getStatus() != OrderStatus.CANCELLED && updateStatusOrderDto.getStatus() == OrderStatus.CANCELLED) {
            order.setStatus(OrderStatus.CANCELLED);
            for (OrderDetail orderItem : order.getOrderDetails()) {
                ProductDetail productDetail = orderItem.getProductDetail();
                productDetail.setQuantity(productDetail.getQuantity() + orderItem.getQuantity());
                productDetail.setSold_quantity(productDetail.getSold_quantity() - orderItem.getQuantity());
                pddao.save(productDetail);
            }
            return HandleResponse.ok(odao.save(order));
        }
        order.setStatus(updateStatusOrderDto.getStatus());
        return HandleResponse.ok(odao.save(order));
    }

    @Override
    public HandleResponse<List<OrderDto>> getMyOrder() {
        List<Order> order = odao.getMyOrder(currentUserService.getCurrentUserId().orElseThrow(
                () -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Cần đăng nhập để thực hiện chức năng này")
        ));
        order.sort((o1, o2) -> o2.getCreated_at().compareTo(o1.getCreated_at()));
        List<OrderDto> orderDtos = order.stream().map(
                Order -> mapper.map(Order, OrderDto.class)).toList();
        return HandleResponse.ok(orderDtos);

    }
}