package com.Beelab.DAO;

import com.Beelab.Entity.Order;
import com.Beelab.Entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetail, Integer> {
    @Query("select p from OrderDetail p where p.order_id = ?1")
    List<OrderDetail> findByOrderId(Integer id);
}