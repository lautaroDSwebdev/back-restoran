package com.example.demo.entity.drink;

import com.example.demo.enums.ECategoryDrinks;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CategoryDrinksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ECategoryDrinks category;

    @OneToMany
    private List<MenuDrinksEntity> list_drinks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public List<MenuDrinksEntity> getList_drinks() {
        return list_drinks;
    }

    public void setList_drinks(List<MenuDrinksEntity> list_drinks) {
        this.list_drinks = list_drinks;
    }

    public ECategoryDrinks getCategory() {
        return category;
    }

    public void setCategory(ECategoryDrinks category) {
        this.category = category;
    }

}
