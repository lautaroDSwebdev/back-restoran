package com.example.demo.service.Impl;

import com.example.demo.entity.dish.MenuDishEntity;
import com.example.demo.entity.drink.MenuDrinksEntity;
import com.example.demo.repository.drink.MenuDrinkRepo;
import com.example.demo.service.inter.drink.IMenuDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuDrinkServiceImpl implements IMenuDrinkService {

    @Autowired
    private MenuDrinkRepo menu_drink_repo;

    @Override
    public Page<MenuDrinksEntity>GetDrinks (int page, int size) {
        Pageable pagin_drinks = PageRequest.of(page, size);
        return menu_drink_repo.findAll(pagin_drinks);
    }




    @Override
    public void PostMenuDrinks(MenuDrinksEntity e) {
        menu_drink_repo.save(e);
    }

    @Override
    public void PutMenuDrinks(MenuDrinksEntity e) {
        this.PostMenuDrinks(e);
    }

    @Override
    public void DeleteMenuDrinks(Long id) {
        menu_drink_repo.deleteById(id);
    }

    @Override
    public MenuDrinksEntity FindMenuDrinks(Long id) {
        MenuDrinksEntity find_drink = menu_drink_repo.findById(id).orElse(null);
        return find_drink;
    }
}
