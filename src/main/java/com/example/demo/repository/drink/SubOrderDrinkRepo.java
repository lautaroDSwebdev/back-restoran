package com.example.demo.repository.drink;

import com.example.demo.entity.drink.SubOrderDrink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubOrderDrinkRepo extends JpaRepository<SubOrderDrink, Long> {
}
