package com.example.demo.entity.dessert;

import com.example.demo.enums.ECategoryDessert;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CategoryDessertsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank
    @Enumerated(EnumType.STRING)
    private ECategoryDessert category;

    @OneToMany
    private List<MenuDessertEntity> list_desserts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ECategoryDessert getcategory() {
        return category;
    }

    public void setcategory(ECategoryDessert category) {
        this.category = category;
    }

    public List<MenuDessertEntity> getList_desserts() {
        return list_desserts;
    }

    public void setList_desserts(List<MenuDessertEntity> list_desserts) {
        this.list_desserts = list_desserts;
    }
}
