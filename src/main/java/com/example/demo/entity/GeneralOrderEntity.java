package com.example.demo.entity;

import com.example.demo.entity.dish.SubOrderDish;
import com.example.demo.entity.drink.SubOrderDrink;
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
public class GeneralOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name_client;

    @OneToMany
    private List<SubOrderDish> sub_order_dish;


    @OneToMany
    private List<SubOrderDrink> sub_order_drink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_client() {
        return name_client;
    }

    public void setName_client(String name_client) {
        this.name_client = name_client;
    }

    public List<SubOrderDish> getSub_order_dish() {
        return sub_order_dish;
    }

    public void setSub_order_dish(List<SubOrderDish> sub_order_dish) {
        this.sub_order_dish = sub_order_dish;
    }

    public List<SubOrderDrink> getSub_order_drink() {
        return sub_order_drink;
    }

    public void setSub_order_drink(List<SubOrderDrink> sub_order_drink) {
        this.sub_order_drink = sub_order_drink;
    }
}
