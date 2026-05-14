package com.example.demo.controllers;

import com.example.demo.entity.drink.CategoryDrinksEntity;
import com.example.demo.service.Impl.CategoryDessertServiceImpl;
import com.example.demo.service.Impl.CategoryDrinkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category/drink")
public class CategoryDrinkController {

    @Autowired
    private CategoryDrinkServiceImpl categdrink_service;

    @GetMapping
    public List<CategoryDrinksEntity> GetCategory(){


        return categdrink_service.GetCategoryDessert();
    }

    @PostMapping
    public String PostCategory(@RequestBody CategoryDrinksEntity e){
        categdrink_service.PostCategoryDrinks(e);
        return "categoria creada";
    }

    @PutMapping
    public CategoryDrinksEntity PutCategory(@RequestBody CategoryDrinksEntity e){
        categdrink_service.PutCategoryDrinks(e);
        return categdrink_service.FindCategoryDrinks(e.getId());
    }

    @DeleteMapping("/{id}")
    public String DeleteCategory(@PathVariable Long id){
        categdrink_service.DeleteCategoryDrinks(id);
        return "categoria eliminada";
    }
    
}
