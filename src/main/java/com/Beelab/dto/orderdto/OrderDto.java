package com.Beelab.dto.orderdto;

import com.Beelab.Common.PaginationRequest;
import com.Beelab.Entity.User;
import com.Beelab.Enum.OrderStatus;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private String id;

    private String customerName;

    private String address;

    private String phoneNumber;

    private String email;

    private OrderStatus status = OrderStatus.UNPROCESSED;

    private User user;

    private double total_amout;

    private List<OrderDetailDto> orderItems;

    private double getTotalAmout(){
        return orderItems.stream().mapToDouble(OrderDetailDto::getTotalPrice).sum();
    }
}
