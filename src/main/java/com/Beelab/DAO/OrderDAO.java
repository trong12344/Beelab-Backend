package com.Beelab.DAO;

import com.Beelab.Entity.Order;
import com.Beelab.dto.orderdto.OrderDetailDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDAO extends JpaRepository<Order, Integer> {

    @Query(nativeQuery = true, value = "select * from orders")
    Page<Order> getAll(Pageable page);

}
