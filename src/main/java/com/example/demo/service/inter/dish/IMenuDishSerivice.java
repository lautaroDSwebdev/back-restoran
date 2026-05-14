package com.example.demo.service.inter.dish;

import com.example.demo.entity.dish.MenuDishEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IMenuDishSerivice {

    public Page<MenuDishEntity> GetMenuDish(int page, int size);
    public void DeleteMenuDish(Long id);
    public void PostMenuDish(MenuDishEntity e);
    public void PutMenuDish(MenuDishEntity e);
    public MenuDishEntity findMenuDish(Long id);
}
