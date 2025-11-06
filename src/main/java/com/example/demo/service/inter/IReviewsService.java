package com.example.demo.service.inter;

import com.example.demo.entity.ReviewsEntity;

import java.util.List;

public interface IReviewsService {
    public List<ReviewsEntity> GetReviews();
    public void PostReviews(ReviewsEntity e);
    public void PutReviews(ReviewsEntity e);
    public void DeleteReviews(Long id);
    public ReviewsEntity FindReviews(Long id);
}
