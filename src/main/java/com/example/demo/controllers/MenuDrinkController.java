package com.example.demo.controllers;

import com.example.demo.entity.drink.MenuDrinksEntity;
import com.example.demo.service.inter.drink.IMenuDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu-drink")
public class MenuDrinkController {

    @Autowired
    private IMenuDrinkService menu_drink;

    @GetMapping
    public List<MenuDrinksEntity> GetDrinks() {
        List<MenuDrinksEntity> get_drinks = menu_drink.GetDrinks();
        return get_drinks;
    }

    @PostMapping
    public String PostDrinks(@RequestBody MenuDrinksEntity e) {
        menu_drink.PostMenuDrinks(e);
        return "menu creado";
    }

    @DeleteMapping("/{id}")
    public String DeleteDrinks(@PathVariable Long id) {
        menu_drink.DeleteMenuDrinks(id);
        return "menu eliminado";
    }

    @PutMapping
    public MenuDrinksEntity PutDrinks(@RequestBody MenuDrinksEntity e) {
        menu_drink.PutMenuDrinks(e);
        return menu_drink.FindMenuDrinks(e.getId());
    }
}
