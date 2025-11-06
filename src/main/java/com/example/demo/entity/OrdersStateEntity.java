package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.security.core.userdetails.User;

import java.util.List;
//@Builder

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrdersStateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotBlank
    @Column(name = "estado_del_pedido")
    private String status;


//    @ManyToOne
//    @JoinColumn(name = "user_orderstate_id")
//    private UserEntity user_orderstate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank String status) {
        this.status = status;
    }
}
