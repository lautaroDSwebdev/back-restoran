package com.example.demo.service.Impl;

import com.example.demo.entity.ReviewsEntity;
import com.example.demo.repository.ReviewsRepo;
import com.example.demo.service.inter.IReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServiceImpl implements IReviewsService {


    @Autowired
    private ReviewsRepo review_repo;

    @Override
    public List<ReviewsEntity> GetReviews() {
        List<ReviewsEntity> get_review = review_repo.findAll();
        return get_review;
    }

    @Override
    public void PostReviews(ReviewsEntity e) {
        review_repo.save(e);
    }

    @Override
    public void PutReviews(ReviewsEntity e) {
        this.PostReviews(e);
    }

    @Override
    public ReviewsEntity FindReviews(Long id) {
        ReviewsEntity find_rev = review_repo.findById(id).orElse(null);
        return find_rev;
    }

    @Override
    public void DeleteReviews(Long id) {
        review_repo.deleteById(id);
    }
}
