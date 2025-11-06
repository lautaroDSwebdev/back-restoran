package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String category_name;

    @OneToMany
    private List<MenuDishEntity> ListMenuDishes;

    public @NotBlank String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(@NotBlank String category_name) {
        this.category_name = category_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MenuDishEntity> getListMenuDishes() {
        return ListMenuDishes;
    }

    public void setListMenuDishes(List<MenuDishEntity> listMenuDishes) {
        ListMenuDishes = listMenuDishes;
    }
}
