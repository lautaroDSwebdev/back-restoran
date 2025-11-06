package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ReservationsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date_time;

    private int people_count;
//    pending, confirmed, cancelled
//    one to one
    private String status;

//    @ManyToOne
//    @JoinColumn(name = "user_reservations_id")
//    private UserEntity user_res;

    @ManyToOne
    @JoinColumn(name = "table_reservation_id")
    private TablesRestaurantEntity table_reservation;

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPeople_count() {
        return people_count;
    }

    public void setPeople_count(int people_count) {
        this.people_count = people_count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TablesRestaurantEntity getTable_reservation() {
        return table_reservation;
    }

    public void setTable_reservation(TablesRestaurantEntity table_reservation) {
        this.table_reservation = table_reservation;
    }
}
