package com.example.demo.controllers;

import com.example.demo.entity.ReviewsEntity;
import com.example.demo.service.Impl.ReviewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    @Autowired
    private ReviewsServiceImpl rev_serv;

    @GetMapping
    public List<ReviewsEntity> GetReviews(){
        List<ReviewsEntity> get_reviews = rev_serv.GetReviews();
        return get_reviews;
    }

    @PostMapping
    public String PostReviews(@RequestBody ReviewsEntity e){
        rev_serv.PostReviews(e);
        return "review creada con exito";
    }
    @DeleteMapping("/{id}")
    public String DeleteReview(@PathVariable Long id){
        rev_serv.DeleteReviews(id);
        return "review eliminada";
    }

    @PutMapping
    public ReviewsEntity PutReviews(@RequestBody ReviewsEntity e){
        rev_serv.PutReviews(e);
        return rev_serv.FindReviews(e.getId());
    }
}
