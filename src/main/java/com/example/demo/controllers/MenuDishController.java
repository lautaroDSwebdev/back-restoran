package com.example.demo.controllers;

import com.example.demo.entity.TablesEntity;
import com.example.demo.entity.dish.MenuDishEntity;
import com.example.demo.service.Impl.MenuDishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu-dish")
public class MenuDishController {

    @Autowired
    private MenuDishServiceImpl menu_service;





    @GetMapping
    public ResponseEntity<Page<MenuDishEntity>> GetDishes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Page<MenuDishEntity> dishes_get = menu_service.GetMenuDish(page, size);

        return ResponseEntity.ok(dishes_get);
    }

    @PostMapping
    public String PostMenus(@RequestBody MenuDishEntity e) {
        menu_service.PostMenuDish(e);
        return "menu creado";
    }

    @DeleteMapping("/{id}")
    public String DeleteMenus(@PathVariable Long id) {
        menu_service.DeleteMenuDish(id);
        return "menu eliminado";
    }

    @PutMapping
    public MenuDishEntity PutMenus(@RequestBody MenuDishEntity e) {
        menu_service.PutMenuDish(e);
        return menu_service.findMenuDish(e.getId());
    }
}
