package com.example.demo.entity.dish;

import com.example.demo.entity.dessert.MenuDessertEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class SubOrderDish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int total_price;


    private int quantity;

    private String details_dish;

    @OneToMany
    @Column(name = "menu_dishes")
    private List<MenuDishEntity> menuDishes;

    @OneToMany
    @Column(name = "menu_dessert_list")
    private List<MenuDessertEntity> menuDessert;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public List<MenuDishEntity> getMenuDishes() {
        return menuDishes;
    }

    public void setMenuDishes(List<MenuDishEntity> menuDishes) {
        this.menuDishes = menuDishes;
    }

    public List<MenuDessertEntity> getMenuDessert() {
        return menuDessert;
    }

    public void setMenuDessert(List<MenuDessertEntity> menuDessert) {
        this.menuDessert = menuDessert;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDetails_dish() {
        return details_dish;
    }

    public void setDetails_dish(String details_dish) {
        this.details_dish = details_dish;
    }



}
