package com.example.demo.repository.dish;

import com.example.demo.entity.dish.SubOrderDish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubOrderDishRepo extends JpaRepository<SubOrderDish, Long> {
}
