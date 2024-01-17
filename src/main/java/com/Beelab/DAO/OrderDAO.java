package com.Beelab.DAO;

import com.Beelab.Entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDAO extends JpaRepository<Order, Integer> {

    @Query(nativeQuery = true, value = "select * from orders")
    Page<Order> getAll(Pageable page);

    @Query("select p from Order p where p.user.id =?1")
    List<Order> getMyOrder(Integer id);

    List<Order> findAllByUserId(int uid);
}
