package com.Beelab.API;

import com.Beelab.Common.Paginated;
import com.Beelab.Entity.Order;
import com.Beelab.Entity.OrderDetail;
import com.Beelab.Entity.ProductImage;
import com.Beelab.Service.ImageService;
import com.Beelab.Service.OrderServ;
import com.Beelab.dto.orderdto.CreateOrderDto;
import com.Beelab.dto.orderdto.UpdateStatusOrderDto;
import com.Beelab.dto.orderdto.getAllOrderDto;
import com.Beelab.dto.productdto.createImageDto;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/order")
public class OrderAPI {
    @Autowired
    OrderServ orderServ;

    @PostMapping("create")
    @Secured("CAN_ORDER")
    public ResponseEntity<Order> create(@RequestBody CreateOrderDto createImageDto){
        return ResponseEntity.ok(orderServ.create(createImageDto).get());
    }

    @GetMapping
    @Secured("ORDER_MANAGEMENT")
    public ResponseEntity<Paginated<Order>> getAllOrder(@Valid @ParameterObject getAllOrderDto getAllOrderDto){
        return ResponseEntity.ok(orderServ.getAllOrder(getAllOrderDto).orThrow());
    }

    @GetMapping("/detail/{id}")
    @Secured("ORDER_MANAGEMENT")
    public ResponseEntity<List<OrderDetail>> getDetailByOrderId(@PathVariable Integer id){
        return ResponseEntity.ok(orderServ.getDetailByOderId(id).orThrow());
    }

    @PatchMapping("updateStatus")
    @Secured("ORDER_MANAGEMENT")
    public ResponseEntity<Order> updateStatus(@RequestBody UpdateStatusOrderDto updateStatusOrderDto){
        return ResponseEntity.ok(orderServ.updateStatusOrder(updateStatusOrderDto).orThrow());
    }
}
