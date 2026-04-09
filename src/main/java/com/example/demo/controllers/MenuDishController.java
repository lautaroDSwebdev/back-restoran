package com.example.demo.controllers;

import com.example.demo.entity.dish.MenuDishEntity;
import com.example.demo.service.Impl.MenuDishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu-dish")
public class MenuDishController {

    @Autowired
    private MenuDishServiceImpl menu_service;

    @GetMapping
    public List<MenuDishEntity> GetAllMenuDishes(){

        return menu_service.GetMenuDish();
    }

    @PostMapping
    public String PostMenus (@RequestBody MenuDishEntity e){
        menu_service.PostMenuDish(e);
        return "menu creado";
    }

    @DeleteMapping("/{id}")
    public String DeleteMenus(@PathVariable Long id){
        menu_service.DeleteMenuDish(id);
        return "menu eliminado";
    }

    @PutMapping
    public MenuDishEntity PutMenus(@RequestBody MenuDishEntity e ){
        menu_service.PutMenuDish(e);
        return menu_service.findMenuDish(e.getId());
    }
}
