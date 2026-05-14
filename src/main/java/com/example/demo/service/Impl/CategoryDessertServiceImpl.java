package com.example.demo.service.Impl;

import com.example.demo.entity.dessert.CategoryDessertsEntity;
import com.example.demo.repository.dessert.CategoryDessertRepo;
import com.example.demo.service.inter.dessert.ICategoryDessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryDessertServiceImpl implements ICategoryDessertService {

    @Autowired
    private CategoryDessertRepo catdessert_repo;

    @Override
    public List<CategoryDessertsEntity> GetCategoryDessert() {
        return catdessert_repo.findAll();
    }

    @Override
    public void PostCategoryDesserts(CategoryDessertsEntity e) {
        catdessert_repo.save(e);
    }

    @Override
    public void PutCategoryDesserts(CategoryDessertsEntity e) {
        this.PostCategoryDesserts(e);
    }

    @Override
    public void DeleteCategoryDesserts(Long id) {
        catdessert_repo.deleteById(id);
    }

    @Override
    public CategoryDessertsEntity FindCategoryDesserts(Long id) {
        CategoryDessertsEntity find_dess_cat = catdessert_repo.findById(id).orElse(null);
        return find_dess_cat;
    }
}
