package com.example.demo.repository.dish;

import com.example.demo.entity.dish.CategoryDishesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDishRepo extends JpaRepository<CategoryDishesEntity, Long> {


}
