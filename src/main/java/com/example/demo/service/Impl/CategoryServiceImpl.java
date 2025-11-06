package com.example.demo.service.Impl;

import com.example.demo.entity.CategoryEntity;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.service.inter.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepo catego_repo;

    @Override
    public List<CategoryEntity> GetCategories() {
        List<CategoryEntity> get_categ = catego_repo.findAll();
        return get_categ;
    }

    @Override
    public void PostCategory(CategoryEntity e) {
        catego_repo.save(e);
    }

    @Override
    public void PutCategory(CategoryEntity e) {
    this.PostCategory(e);
    }

    @Override
    public void DeleteCategory(Long id) {
        catego_repo.deleteById(id);
    }

    @Override
    public CategoryEntity FindCategory(Long id) {
        CategoryEntity find_categ = catego_repo.findById(id).orElse(null);
        return find_categ;
    }
}
