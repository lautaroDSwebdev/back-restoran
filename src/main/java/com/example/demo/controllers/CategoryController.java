package com.example.demo.controllers;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.service.Impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {


//hola
    @Autowired
    private CategoryServiceImpl categ_service;

    @GetMapping
    public List<CategoryEntity> GetCategory(){
        List<CategoryEntity> get_categ =  categ_service.GetCategories();
        return get_categ;
    }

    @PostMapping
    public String PostCategory(@RequestBody CategoryEntity e){
        categ_service.PostCategory(e);
        return "categoria creada";
    }

    @PutMapping
    public CategoryEntity PutCategory(@RequestBody CategoryEntity e){
        categ_service.PutCategory(e);
        return categ_service.FindCategory(e.getId());
    }

    @DeleteMapping("/{id}")
    public String DeleteCategory(@PathVariable Long id){
        categ_service.DeleteCategory(id);
        return "categoria eliminada";
    }

}
