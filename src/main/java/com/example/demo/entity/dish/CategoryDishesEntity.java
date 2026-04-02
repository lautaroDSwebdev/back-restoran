package com.example.demo.entity.dish;

import com.example.demo.enums.ECategoryDishes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CategoryDishesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ECategoryDishes category;

    @OneToMany
    private List<MenuDishEntity> list_dishes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Enum<ECategoryDishes> getCategory() {
        return category;
    }

    public void setCategory(ECategoryDishes category) {
        this.category = category;
    }

    public List<MenuDishEntity> getList_dishes() {
        return list_dishes;
    }

    public void setList_dishes(List<MenuDishEntity> list_dishes) {
        this.list_dishes = list_dishes;
    }
}
