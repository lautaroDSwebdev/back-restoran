package com.example.demo.repository.drink;

import com.example.demo.entity.drink.CategoryDrinksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDrinkRepo extends JpaRepository<CategoryDrinksEntity, Long> {
}
