package com.example.demo.service.Impl;

import com.example.demo.entity.TablesEntity;
import com.example.demo.entity.dish.MenuDishEntity;
import com.example.demo.repository.dish.MenuDishRepo;
import com.example.demo.service.inter.dish.IMenuDishSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class MenuDishServiceImpl implements IMenuDishSerivice {

    @Autowired
    private MenuDishRepo menu_repo;


    @Override
    public Page<MenuDishEntity> GetMenuDish(int page, int size) {
        Pageable pagin_prod = PageRequest.of(page, size);
        return menu_repo.findAll(pagin_prod);
    }

    @Override
    public void DeleteMenuDish(Long id) {
        menu_repo.deleteById(id);
    }

    @Override
    public void PostMenuDish(MenuDishEntity e) {
        menu_repo.save(e);
    }

    @Override
    public void PutMenuDish(MenuDishEntity e) {
        this.PostMenuDish(e);
    }

    @Override
    public MenuDishEntity findMenuDish(Long id) {
        MenuDishEntity fint_menu = menu_repo.findById(id).orElse(null);
        return fint_menu;
    }
}
