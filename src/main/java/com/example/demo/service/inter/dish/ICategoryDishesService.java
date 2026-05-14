package com.example.demo.service.inter.dish;

import com.example.demo.entity.dish.CategoryDishesEntity;

import java.util.List;

public interface ICategoryDishesService {
    public List<CategoryDishesEntity> GetCategoriesDishes();

    public void PostCategoryDishes(CategoryDishesEntity e);
    public void PutCategoryDishes(CategoryDishesEntity e);
    public void DeleteCategoryDishes(Long id);
    public CategoryDishesEntity FindCategoryDishes(Long id);
}
