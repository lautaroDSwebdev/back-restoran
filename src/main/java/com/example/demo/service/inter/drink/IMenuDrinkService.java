package com.example.demo.service.inter.drink;


import com.example.demo.entity.drink.MenuDrinksEntity;
import org.springframework.data.domain.Page;

public interface IMenuDrinkService {

    public Page<MenuDrinksEntity> GetDrinks(int page, int  size);

    public void PostMenuDrinks(MenuDrinksEntity e);
    public void PutMenuDrinks(MenuDrinksEntity e);
    public void DeleteMenuDrinks(Long id);
    public MenuDrinksEntity FindMenuDrinks(Long id);
}
