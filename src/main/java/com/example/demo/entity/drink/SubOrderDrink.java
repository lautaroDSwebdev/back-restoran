package com.example.demo.entity.drink;

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
public class SubOrderDrink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int total_price;


    private int quantity;

    private String details_drink;

    @OneToMany
    private List<MenuDrinksEntity> menu_drinks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MenuDrinksEntity> getmenu_drinks() {
        return menu_drinks;
    }

    public void setmenu_drinks(List<MenuDrinksEntity> menu_drinks) {
        this.menu_drinks = menu_drinks;
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

    public String getDetails_drink() {
        return details_drink;
    }

    public void setDetails_drink(String details_drink) {
        this.details_drink = details_drink;
    }
}
