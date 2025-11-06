//package com.example.demo.entity;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
//import lombok.*;
//
//import java.util.List;
//import java.util.Set;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//@Entity
////@Table(name = "users")
//public class UserEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long userId;
//
//    @NotBlank
//    @Size(max = 30)
//    private String username;
//
//    @Email
//    @NotBlank
//    @Size(max = 50)
//    private String email;
//
//    @NotBlank
//    private String password;
//
//    @ManyToMany(fetch = FetchType.EAGER, targetEntity = RoleEntity.class, cascade = CascadeType.PERSIST)
//    @JoinTable(name = "table_user_roles",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<RoleEntity> roles;
//
////    @OneToMany
////    private List<ReservationsEntity> listReserv;
//
////    @OneToMany
////    private List<ReviewsEntity> reviewsUser;
////
////
////    @OneToMany
////    private List<OrdersStateEntity> ListOrders;
//
//
//    public @Email @NotBlank @Size(max = 50) String getEmail() {
//        return email;
//    }
//
//    public void setEmail(@Email @NotBlank @Size(max = 50) String email) {
//        this.email = email;
//    }
//
//    public @NotBlank String getPassword() {
//        return password;
//    }
//
//    public void setPassword(@NotBlank String password) {
//        this.password = password;
//    }
//
//    public Set<RoleEntity> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<RoleEntity> roles) {
//        this.roles = roles;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public @NotBlank @Size(max = 30) String getUsername() {
//        return username;
//    }
//
//    public void setUsername(@NotBlank @Size(max = 30) String username) {
//        this.username = username;
//    }
//}
