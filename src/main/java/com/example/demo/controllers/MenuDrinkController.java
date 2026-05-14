package com.example.demo.controllers;

import com.example.demo.entity.drink.MenuDrinksEntity;
import com.example.demo.service.inter.drink.IMenuDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu-drink")
public class MenuDrinkController {

    @Autowired
    private IMenuDrinkService menu_drink;

    @GetMapping
    public ResponseEntity<Page<MenuDrinksEntity>> GetDrinks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<MenuDrinksEntity> drinks_get = menu_drink.GetDrinks(page, size);

        return ResponseEntity.ok(drinks_get);
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
