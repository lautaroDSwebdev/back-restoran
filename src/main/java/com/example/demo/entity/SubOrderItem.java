package com.example.demo.entity;

import com.example.demo.entity.dessert.MenuDessertEntity;
import com.example.demo.entity.dish.MenuDishEntity;
import com.example.demo.entity.drink.MenuDrinksEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class SubOrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Aquí está el truco: Referencias opcionales
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dish_id")
    private MenuDishEntity dish;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dessert_id")
    private MenuDessertEntity dessert;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drink_id")
    private MenuDrinksEntity drink;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MenuDishEntity getDish() {
        return dish;
    }

    public void setDish(MenuDishEntity dish) {
        this.dish = dish;
    }

    public MenuDessertEntity getDessert() {
        return dessert;
    }

    public void setDessert(MenuDessertEntity dessert) {
        this.dessert = dessert;
    }

    public MenuDrinksEntity getDrink() {
        return drink;
    }

    public void setDrink(MenuDrinksEntity drink) {
        this.drink = drink;
    }


}
