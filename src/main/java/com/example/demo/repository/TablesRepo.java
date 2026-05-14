package com.example.demo.repository;

import com.example.demo.entity.TablesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TablesRepo extends JpaRepository<TablesEntity, Long> {
}
