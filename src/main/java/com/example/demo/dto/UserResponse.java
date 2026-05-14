package com.example.demo.dto;

import com.example.demo.entity.UsersEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record UserResponse(
        Long id,
        String name,
        @JsonProperty("lastname")
        String lastname,

        String email,
        String role,
        int dni
        ) {
    public static UserResponse fromUser(UsersEntity e){
        return UserResponse.builder()
                .id(e.getId())
                .name(e.getUsername())
                .email(e.getEmail())
                .dni(e.getDni())
                .role(e.getRoles().toString())
                .lastname(e.getLastname())
                .build();


    }

}
