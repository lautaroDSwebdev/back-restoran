package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int Quantity;

    @NotNull
    private int price;

    @OneToMany
    private List<OrdersStateEntity> ListOrdersStates;

    @OneToMany
    private List<MenuDishEntity> ListDiches;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MenuDishEntity> getListDiches() {
        return ListDiches;
    }

    public void setListDiches(List<MenuDishEntity> listDiches) {
        ListDiches = listDiches;
    }

    public List<OrdersStateEntity> getListOrdersStates() {
        return ListOrdersStates;
    }

    public void setListOrdersStates(List<OrdersStateEntity> listOrdersStates) {
        ListOrdersStates = listOrdersStates;
    }

    @NotNull
    public int getPrice() {
        return price;
    }

    public void setPrice(@NotNull int price) {
        this.price = price;
    }

    @NotNull
    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(@NotNull int quantity) {
        Quantity = quantity;
    }
}
