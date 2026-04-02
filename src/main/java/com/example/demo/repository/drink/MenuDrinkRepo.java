package com.example.demo.repository.drink;

import com.example.demo.entity.drink.MenuDrinksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDrinkRepo extends JpaRepository<MenuDrinksEntity, Long> {
}
