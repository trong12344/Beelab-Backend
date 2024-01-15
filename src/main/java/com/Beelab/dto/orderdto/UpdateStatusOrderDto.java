package com.Beelab.dto.orderdto;

import com.Beelab.Enum.OrderStatus;
import lombok.Data;

@Data
public class UpdateStatusOrderDto {
    private int orderId;
    private OrderStatus status;
}
