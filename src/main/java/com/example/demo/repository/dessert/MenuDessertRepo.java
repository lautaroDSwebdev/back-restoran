package com.example.demo.repository.dessert;

import com.example.demo.entity.dessert.MenuDessertEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDessertRepo extends JpaRepository<MenuDessertEntity, Long> {
}
