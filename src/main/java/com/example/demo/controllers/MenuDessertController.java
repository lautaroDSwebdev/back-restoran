package com.example.demo.controllers;

import com.example.demo.entity.dessert.MenuDessertEntity;
import com.example.demo.entity.dish.MenuDishEntity;
import com.example.demo.service.inter.dessert.IMenuDessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu-dessert")
public class MenuDessertController {

    @Autowired
    private IMenuDessertService menu_dessert;

    @GetMapping
    public ResponseEntity<Page<MenuDessertEntity>> GetDesserts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<MenuDessertEntity> dessert_get = menu_dessert.GetDessert(page, size);

        return ResponseEntity.ok(dessert_get);
    }

    @PostMapping
    public String PostDessert(@RequestBody MenuDessertEntity e) {
        menu_dessert.PostMenuDessert(e);
        return "menu creado";
    }

    @DeleteMapping("/{id}")
    public String DeleteDessert(@PathVariable Long id) {
        menu_dessert.DeleteMenuDessert(id);
        return "menu eliminado";
    }

    @PutMapping
    public MenuDessertEntity PutDessert(@RequestBody MenuDessertEntity e) {
        menu_dessert.PutMenuDessert(e);
        return menu_dessert.FindMenuDessert(e.getId());
    }
}
