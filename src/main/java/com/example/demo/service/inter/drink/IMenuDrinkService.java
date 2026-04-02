package com.example.demo.service.inter.drink;


import com.example.demo.entity.drink.MenuDrinksEntity;

import java.util.List;

public interface IMenuDrinkService {

    public List<MenuDrinksEntity> GetDrinks();

    public void PostMenuDrinks(MenuDrinksEntity e);
    public void PutMenuDrinks(MenuDrinksEntity e);
    public void DeleteMenuDrinks(Long id);
    public MenuDrinksEntity FindMenuDrinks(Long id);
}
