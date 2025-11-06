package com.example.demo.service.inter;

import com.example.demo.entity.MenuDishEntity;

import java.util.List;

public interface IMenuDishSerivice {

    public List<MenuDishEntity> GetMenuDish();
    public void DeleteMenuDish(Long id);
    public void PostMenuDish(MenuDishEntity e);
    public void PutMenuDish(MenuDishEntity e);
    public MenuDishEntity findMenuDish(Long id);
}
