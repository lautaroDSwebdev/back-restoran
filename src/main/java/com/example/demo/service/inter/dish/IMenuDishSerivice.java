package com.example.demo.service.inter.dish;

import com.example.demo.entity.dish.MenuDishEntity;

import java.util.List;

public interface IMenuDishSerivice {

    public List<MenuDishEntity> GetMenuDish();
    public void DeleteMenuDish(Long id);
    public void PostMenuDish(MenuDishEntity e);
    public void PutMenuDish(MenuDishEntity e);
    public MenuDishEntity findMenuDish(Long id);
}
