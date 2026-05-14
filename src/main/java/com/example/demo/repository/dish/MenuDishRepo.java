package com.example.demo.repository.dish;

import com.example.demo.entity.dish.MenuDishEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDishRepo extends JpaRepository<MenuDishEntity, Long> {
}
