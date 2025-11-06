package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InventoryItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private int stock;

    @NotBlank
    private String unit;

    @ManyToOne
    @JoinColumn(name = "inventiry_dish_id")
    private MenuDishEntity menudish;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MenuDishEntity getMenudish() {
        return menudish;
    }

    public void setMenudish(MenuDishEntity menudish) {
        this.menudish = menudish;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    @NotBlank
    public int getStock() {
        return stock;
    }

    public void setStock(@NotBlank int stock) {
        this.stock = stock;
    }

    public @NotBlank String getUnit() {
        return unit;
    }

    public void setUnit(@NotBlank String unit) {
        this.unit = unit;
    }
}
