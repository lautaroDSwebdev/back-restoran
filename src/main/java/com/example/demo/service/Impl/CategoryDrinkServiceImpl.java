package com.example.demo.service.Impl;

import com.example.demo.entity.drink.CategoryDrinksEntity;
import com.example.demo.repository.drink.CategoryDrinkRepo;
import com.example.demo.service.inter.drink.ICategoryDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryDrinkServiceImpl implements ICategoryDrinkService {


    @Autowired
    private CategoryDrinkRepo cat_drink_repo;

    @Override
    public List<CategoryDrinksEntity> GetCategoryDessert() {
        List<CategoryDrinksEntity> cat_drink = cat_drink_repo.findAll();
        return cat_drink;
    }

    @Override
    public void PostCategoryDrinks(CategoryDrinksEntity e) {
        cat_drink_repo.save(e);
    }

    @Override
    public void PutCategoryDrinks(CategoryDrinksEntity e) {
        this.PostCategoryDrinks(e);
    }

    @Override
    public void DeleteCategoryDrinks(Long id) {
        cat_drink_repo.deleteById(id);
    }

    @Override
    public CategoryDrinksEntity FindCategoryDrinks(Long id) {
        CategoryDrinksEntity find_cat_drink = cat_drink_repo.findById(id).orElse(null);
        return find_cat_drink;
    }
}
