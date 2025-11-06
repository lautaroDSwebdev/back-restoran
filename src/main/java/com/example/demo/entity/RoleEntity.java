package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    @Enumerated(EnumType.STRING)
    private ERole roleName;

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public ERole getRoleName() {
        return roleName;
    }

    public void setRoleName(ERole roleName) {
        this.roleName = roleName;
    }

}
