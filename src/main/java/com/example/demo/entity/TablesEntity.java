package com.example.demo.entity;

import com.example.demo.enums.ETableState;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TablesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull(message = "la capacidad no puede ser nula")
    @Positive(message = "La capacidad debe ser un número mayor a 0")
    private int capacity;

//    @NotBlank
    @NotNull(message = "la locacion de la mesa no puede ser nula")
    private String location;

    @Enumerated(EnumType.STRING)
    private ETableState state_capacity;

    @OneToOne
    @JoinColumn(name = "general_order_id")
    private GeneralOrderEntity general_order;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public GeneralOrderEntity getGeneral_order() {
        return general_order;
    }

    public void setGeneral_order(GeneralOrderEntity general_order) {
        this.general_order = general_order;
    }

    public ETableState getState_capacity() {
        return state_capacity;
    }

    public void setState_capacity(ETableState state_capacity) {
        this.state_capacity = state_capacity;
    }
}
