package com.example.demo.entity.dish;

import com.example.demo.entity.dessert.MenuDessertEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
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
    private List<MenuDishEntity> menu_dishes;

    @OneToMany
    private List<MenuDessertEntity> menu_dessert;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MenuDishEntity> getmenu_dishes() {
        return menu_dishes;
    }

    public void setmenu_dishes(List<MenuDishEntity> menu_dishes) {
        this.menu_dishes = menu_dishes;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
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

    public List<MenuDishEntity> getMenu_dishes() {
        return menu_dishes;
    }

    public void setMenu_dishes(List<MenuDishEntity> menu_dishes) {
        this.menu_dishes = menu_dishes;
    }

    public List<MenuDessertEntity> getMenu_dessert() {
        return menu_dessert;
    }

    public void setMenu_dessert(List<MenuDessertEntity> menu_dessert) {
        this.menu_dessert = menu_dessert;
    }
}
