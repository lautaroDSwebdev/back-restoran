package com.example.demo.service.inter.drink;

import com.example.demo.entity.drink.SubOrderDrink;

import java.util.List;

public interface ISubOrderDrinkService {
    public List<SubOrderDrink> GetSubOrderDrink();

    public void PostSubOrderDrink(SubOrderDrink e);
    public void PutSubOrderDrink(SubOrderDrink e);
    public void DeleteSubOrderDrink(Long id);
    public SubOrderDrink FindSubOrderDrink(Long id);
}
