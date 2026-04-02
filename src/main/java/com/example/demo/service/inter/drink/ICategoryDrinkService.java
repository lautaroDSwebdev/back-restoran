package com.example.demo.service.inter.drink;

import com.example.demo.entity.drink.CategoryDrinksEntity;

import java.util.List;

public interface ICategoryDrinkService {
    public List<CategoryDrinksEntity> GetCategoryDessert();
    public void PostCategoryDrinks(CategoryDrinksEntity e);
    public void PutCategoryDrinks(CategoryDrinksEntity e);
    public void DeleteCategoryDrinks(Long id);
    public CategoryDrinksEntity FindCategoryDrinks(Long id);
}
