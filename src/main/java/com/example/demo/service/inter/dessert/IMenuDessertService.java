package com.example.demo.service.inter.dessert;


import com.example.demo.entity.dessert.MenuDessertEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMenuDessertService {
    public Page<MenuDessertEntity> GetDessert(int page, int size);

    public void PostMenuDessert(MenuDessertEntity e);
    public void PutMenuDessert(MenuDessertEntity e);
    public void DeleteMenuDessert(Long id);
    public MenuDessertEntity FindMenuDessert(Long id);
}
