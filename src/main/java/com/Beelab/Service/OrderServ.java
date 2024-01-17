package com.Beelab.Service;
import com.Beelab.Common.HandleResponse;
import com.Beelab.Common.Paginated;
import com.Beelab.Entity.Order;
import com.Beelab.Entity.OrderDetail;
import com.Beelab.dto.orderdto.CreateOrderDto;
import com.Beelab.dto.orderdto.UpdateStatusOrderDto;
import com.Beelab.dto.orderdto.getAllOrderDto;

import java.util.List;

public interface OrderServ{
    HandleResponse<Order> create(CreateOrderDto createOrderDto);

    HandleResponse<Paginated<Order>> getAllOrder(getAllOrderDto getAllOrderDto);

    HandleResponse<List<OrderDetail>> getDetailByOderId(Integer oderId);

    HandleResponse<Order> updateStatusOrder(UpdateStatusOrderDto updateStatusOrderDto);

}
