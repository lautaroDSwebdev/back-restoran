package com.example.demo.service.Impl;

import com.example.demo.entity.drink.SubOrderDrink;
import com.example.demo.repository.drink.SubOrderDrinkRepo;
import com.example.demo.service.inter.drink.ISubOrderDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubOrderDrinkServiceImpl implements ISubOrderDrinkService {

    @Autowired
    private SubOrderDrinkRepo sub_drink_repo;

    @Override
    public List<SubOrderDrink> GetSubOrderDrink() {
        return sub_drink_repo.findAll();
    }

    @Override
    public void PostSubOrderDrink(SubOrderDrink e) {
        sub_drink_repo.save(e);
    }

    @Override
    public void PutSubOrderDrink(SubOrderDrink e) {
        this.PostSubOrderDrink(e);
    }

    @Override
    public void DeleteSubOrderDrink(Long id) {
        sub_drink_repo.deleteById(id);
    }

    @Override
    public SubOrderDrink FindSubOrderDrink(Long id) {
        return sub_drink_repo.findById(id).orElse(null);
    }
}
