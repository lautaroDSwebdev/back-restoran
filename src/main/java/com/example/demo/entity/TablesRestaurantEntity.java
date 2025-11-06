package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TablesRestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberOfTable;

    @NotNull(message = "la capacidad no puede ser nula")
    @Positive(message = "La capacidad debe ser un número mayor a 0")
    private int capacity;

    @NotBlank
    private String location;

    @OneToMany
    private List<ReservationsEntity> reservationsTable;

    @NotNull(message = "la capacidad no puede ser nula")
    @Positive(message = "La capacidad debe ser un número mayor a 0")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(@NotNull(message = "la capacidad no puede ser nula") @Positive(message = "La capacidad debe ser un número mayor a 0") int capacity) {
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getLocation() {
        return location;
    }

    public void setLocation(@NotBlank String location) {
        this.location = location;
    }

    public int getNumberOfTable() {
        return numberOfTable;
    }

    public void setNumberOfTable(int numberOfTable) {
        this.numberOfTable = numberOfTable;
    }

    public List<ReservationsEntity> getReservationsTable() {
        return reservationsTable;
    }

    public void setReservationsTable(List<ReservationsEntity> reservationsTable) {
        this.reservationsTable = reservationsTable;
    }
}
