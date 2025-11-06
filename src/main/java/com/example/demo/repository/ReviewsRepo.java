package com.example.demo.repository;

import com.example.demo.entity.ReviewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewsRepo extends JpaRepository<ReviewsEntity, Long> {


}
