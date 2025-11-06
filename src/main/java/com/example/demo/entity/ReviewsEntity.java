package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ReviewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Size(max = 5)
    @NotNull
    @Column(name = "rango")
    private int range;

    @NotBlank
    @Column(name = "comentario")
    private String coment;

    @NotBlank
    private String date;

    //    @ManyToOne
//    @JoinColumn(name = "userentity_reviews")
//    private UserEntity user;
//
//    @ManyToOne
//    @JoinColumn(name = "user_reviews_column")
//    private UserEntity user_review;
//
    @ManyToOne
    @JoinColumn(name = "menu_reviews")
    private MenuDishEntity menu_dish;

    public @NotBlank String getComent() {
        return coment;
    }

    public void setComent(@NotBlank String coment) {
        this.coment = coment;
    }

    public @NotBlank String getDate() {
        return date;
    }

    public void setDate(@NotBlank String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MenuDishEntity getMenu_dish() {
        return menu_dish;
    }

    public void setMenu_dish(MenuDishEntity menu_dish) {
        this.menu_dish = menu_dish;
    }

    @NotNull
    public int getRange() {
        return range;
    }

    public void setRange(@NotNull int range) {
        this.range = range;
    }
}
