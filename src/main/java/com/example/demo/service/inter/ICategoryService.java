package com.example.demo.service.inter;

import com.example.demo.entity.CategoryEntity;

import java.util.List;

public interface ICategoryService {
    public List<CategoryEntity> GetCategories();

    public void PostCategory(CategoryEntity e);
    public void PutCategory(CategoryEntity e);
    public void DeleteCategory(Long id);
    public CategoryEntity FindCategory(Long id);
}
