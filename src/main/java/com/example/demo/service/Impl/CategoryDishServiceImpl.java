package com.example.demo.service.Impl;

import com.example.demo.entity.dish.CategoryDishesEntity;
import com.example.demo.repository.dish.CategoryDishRepo;
import com.example.demo.service.inter.dish.ICategoryDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryDishServiceImpl implements ICategoryDishesService {

    @Autowired
    private CategoryDishRepo categodish_repo;


    @Override
    public List<CategoryDishesEntity> GetCategoriesDishes() {
        List<CategoryDishesEntity> dish = categodish_repo.findAll();
        return dish;
    }

    @Override
    public void PostCategoryDishes(CategoryDishesEntity e) {
        categodish_repo.save(e);
    }

    @Override
    public void PutCategoryDishes(CategoryDishesEntity e) {

    }

    @Override
    public void DeleteCategoryDishes(Long id) {
        categodish_repo.deleteById(id);
    }

    @Override
    public CategoryDishesEntity FindCategoryDishes(Long id) {
        CategoryDishesEntity find_categ = categodish_repo.findById(id).orElse(null);
        return find_categ;
    }
}
