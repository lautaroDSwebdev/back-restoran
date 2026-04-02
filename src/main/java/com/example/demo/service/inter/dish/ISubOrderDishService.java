package com.example.demo.service.inter.dish;

import com.example.demo.entity.dish.SubOrderDish;

import java.util.List;

public interface ISubOrderDishService {

    public List<SubOrderDish> GetSubOrderDish();

    public void PostSubOrderDish(SubOrderDish e);
    public void PutSubOrderDish(SubOrderDish e);
    public void DeleteSubOrderDish(Long id);
    public SubOrderDish FindSubOrderDish(Long id);
}
