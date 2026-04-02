package com.example.demo.service.inter.dessert;


import com.example.demo.entity.dessert.MenuDessertEntity;

import java.util.List;

public interface IMenuDessertService {
    public List<MenuDessertEntity> GetDessert();

    public void PostMenuDessert(MenuDessertEntity e);
    public void PutMenuDessert(MenuDessertEntity e);
    public void DeleteMenuDessert(Long id);
    public MenuDessertEntity FindMenuDessert(Long id);
}
