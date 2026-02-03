package com.example.demo.repository;

import com.example.demo.entity.UsersEntity;
import com.example.demo.entity.UsersEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UsersEntity, Long> {

    Optional<UsersEntity> findByUsername(String username);

    @Query("select u from UsersEntity u where u.username = ?1")
    Optional<UsersEntity> getName(String username);

}