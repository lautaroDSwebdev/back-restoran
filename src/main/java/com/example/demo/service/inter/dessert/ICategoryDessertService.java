package com.example.demo.service.inter.dessert;

import com.example.demo.entity.dessert.CategoryDessertsEntity;

import java.util.List;

public interface ICategoryDessertService {
    public List<CategoryDessertsEntity> GetCategoryDessert();
    public void PostCategoryDesserts(CategoryDessertsEntity e);
    public void PutCategoryDesserts(CategoryDessertsEntity e);
    public void DeleteCategoryDesserts(Long id);
    public CategoryDessertsEntity FindCategoryDesserts(Long id);

}
