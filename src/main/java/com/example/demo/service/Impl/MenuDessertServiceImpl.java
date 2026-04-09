package com.example.demo.service.Impl;

import com.example.demo.entity.dessert.MenuDessertEntity;
import com.example.demo.repository.dessert.MenuDessertRepo;
import com.example.demo.service.inter.dessert.IMenuDessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuDessertServiceImpl implements IMenuDessertService {

    @Autowired
    private MenuDessertRepo menuDessertRepo;

//    @Override
//    public List<MenuDessertEntity> GetCategories() {
//        return menuDessertRepo.findAll();
//    }


    @Override
    public List<MenuDessertEntity> GetDessert() {
        return menuDessertRepo.findAll();
    }

    @Override
    public void PostMenuDessert(MenuDessertEntity e) {
        menuDessertRepo.save(e);
    }

    @Override
    public void PutMenuDessert(MenuDessertEntity e) {
        menuDessertRepo.save(e);
    }

    @Override
    public void DeleteMenuDessert(Long id) {
        menuDessertRepo.deleteById(id);
    }

    @Override
    public MenuDessertEntity FindMenuDessert(Long id) {
        MenuDessertEntity find_dessert = menuDessertRepo.findById(id).orElse(null);
        return find_dessert;
    }
}
