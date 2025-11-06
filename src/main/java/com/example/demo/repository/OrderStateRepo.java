package com.example.demo.repository;

import com.example.demo.entity.OrdersStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStateRepo extends JpaRepository<OrdersStateEntity, Long> {
}
