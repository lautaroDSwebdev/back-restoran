package com.example.demo.entity;

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


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sub_order_general_id")
    private List<SubOrderItem> sub_order_list; // Aquí dentro puede haber un plato, un postre O una bebida

    private int total_price;

    private String details_order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SubOrderItem> getSub_order_list() {
        return sub_order_list;
    }

    public void setSub_order_list(List<SubOrderItem> sub_order_list) {
        this.sub_order_list = sub_order_list;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public String getDetails_order() {
        return details_order;
    }

    public void setDetails_order(String details_order) {
        this.details_order = details_order;
    }
}
