package com.example.demo.service.Impl;

import com.example.demo.entity.dish.SubOrderDish;
import com.example.demo.repository.dish.SubOrderDishRepo;
import com.example.demo.service.inter.dish.ISubOrderDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubOrderDishServiceImpl implements ISubOrderDishService {

    @Autowired
    private SubOrderDishRepo sub_dish_repo;


    @Override
    public List<SubOrderDish> GetSubOrderDish() {
        return sub_dish_repo.findAll();
    }

    @Override
    public void PostSubOrderDish(SubOrderDish e) {
        sub_dish_repo.save(e);
    }

    @Override
    public void PutSubOrderDish(SubOrderDish e) {
    this.PostSubOrderDish(e);
    }

    @Override
    public void DeleteSubOrderDish(Long id) {
        sub_dish_repo.deleteById(id);
    }

    @Override
    public SubOrderDish FindSubOrderDish(Long id) {
        return sub_dish_repo.findById(id).orElse(null);
    }
}
