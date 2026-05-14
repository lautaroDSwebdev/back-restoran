package com.example.demo.controllers;

import com.example.demo.entity.dish.CategoryDishesEntity;
import com.example.demo.service.Impl.CategoryDishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category/dish")
public class CategoryDishController {

    @Autowired
    private CategoryDishServiceImpl categdish_service;

    @GetMapping
    public List<CategoryDishesEntity> GetCategory(){
        List<CategoryDishesEntity> get_categ =  categdish_service.GetCategoriesDishes();
        return get_categ;
    }

    @PostMapping
    public String PostCategory(@RequestBody CategoryDishesEntity e){
        categdish_service.PostCategoryDishes(e);
        return "categoria creada";
    }

    @PutMapping
    public CategoryDishesEntity PutCategory(@RequestBody CategoryDishesEntity e){
        categdish_service.PutCategoryDishes(e);
        return categdish_service.FindCategoryDishes(e.getId());
    }

    @DeleteMapping("/{id}")
    public String DeleteCategory(@PathVariable Long id){
        categdish_service.DeleteCategoryDishes(id);
        return "categoria eliminada";
    }

}
