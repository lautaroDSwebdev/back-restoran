package com.example.demo.controllers;

import com.example.demo.entity.dish.SubOrderDish;
import com.example.demo.service.inter.dish.ISubOrderDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sub-order-dish")
public class SubOrderDishController {

    @Autowired
    private ISubOrderDishService subOrderDishService;

    @GetMapping
    public List<SubOrderDish> getSubOrders() {
        return subOrderDishService.GetSubOrderDish();
    }

    @PostMapping
    public String postSubOrder(@RequestBody SubOrderDish e) {
        subOrderDishService.PostSubOrderDish(e);
        return "Sub orden de plato creada!";
    }

    @DeleteMapping("/{id}")
    public String deleteSubOrder(@PathVariable Long id) {
        subOrderDishService.DeleteSubOrderDish(id);
        return "Sub order dish eliminada 🗑";
    }

    @PutMapping
    public SubOrderDish putSubOrder(@RequestBody SubOrderDish e) {
        subOrderDishService.PutSubOrderDish(e);
        return subOrderDishService.FindSubOrderDish(e.getId());
    }

    @GetMapping("/{id}")
    public SubOrderDish findSubOrder(@PathVariable Long id) {
        return subOrderDishService.FindSubOrderDish(id);
    }
}
