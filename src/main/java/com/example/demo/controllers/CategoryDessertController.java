package com.example.demo.controllers;

import com.example.demo.entity.dessert.CategoryDessertsEntity;
import com.example.demo.service.Impl.CategoryDessertServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category/dessert")
public class CategoryDessertController {

    @Autowired
    private CategoryDessertServiceImpl categdessert_service;

    @GetMapping
    public List<CategoryDessertsEntity> GetCategory(){
        List<CategoryDessertsEntity> get_categ =  categdessert_service.GetCategoryDessert();
        return get_categ;
    }

    @PostMapping
    public String PostCategory(@RequestBody CategoryDessertsEntity e){
        categdessert_service.PostCategoryDesserts(e);
        return "categoria creada";
    }

    @PutMapping
    public CategoryDessertsEntity PutCategory(@RequestBody CategoryDessertsEntity e){
        categdessert_service.PutCategoryDesserts(e);
        return categdessert_service.FindCategoryDesserts(e.getId());
    }

    @DeleteMapping("/{id}")
    public String DeleteCategory(@PathVariable Long id){
        categdessert_service.DeleteCategoryDesserts(id);
        return "categoria eliminada";
    }
}
