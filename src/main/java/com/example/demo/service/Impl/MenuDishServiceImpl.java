package com.example.demo.service.Impl;

import com.example.demo.entity.MenuDishEntity;
import com.example.demo.repository.MenuDishRepo;
import com.example.demo.service.inter.IMenuDishSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuDishServiceImpl implements IMenuDishSerivice {

    private MenuDishRepo menu_repo;

    @Override
    public List<MenuDishEntity> GetMenuDish() {
        List<MenuDishEntity> get_menu = menu_repo.findAll();
        return get_menu;
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
