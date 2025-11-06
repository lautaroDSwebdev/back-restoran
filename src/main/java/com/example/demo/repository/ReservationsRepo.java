package com.example.demo.repository;

import com.example.demo.entity.ReservationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepo extends JpaRepository<ReservationsEntity, Long> {
}
