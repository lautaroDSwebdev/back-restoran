package com.example.demo.repository.dessert;

import com.example.demo.entity.dessert.CategoryDessertsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDessertRepo extends JpaRepository<CategoryDessertsEntity, Long> {
}
