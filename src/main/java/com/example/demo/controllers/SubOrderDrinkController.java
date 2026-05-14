package com.example.demo.controllers;

import com.example.demo.entity.drink.SubOrderDrink;
import com.example.demo.service.inter.drink.ISubOrderDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sub-order-drink")
public class SubOrderDrinkController {

    @Autowired
    private ISubOrderDrinkService subOrderDrinkService;

    @GetMapping
    public List<SubOrderDrink> getSubOrders() {
        return subOrderDrinkService.GetSubOrderDrink();
    }

    @PostMapping
    public String postSubOrder(@RequestBody SubOrderDrink e) {
        subOrderDrinkService.PostSubOrderDrink(e);
        return "Sub order drink created";
    }

    @DeleteMapping("/{id}")
    public String deleteSubOrder(@PathVariable Long id) {
        subOrderDrinkService.DeleteSubOrderDrink(id);
        return "Sub order drink deleted";
    }

    @PutMapping
    public SubOrderDrink putSubOrder(@RequestBody SubOrderDrink e) {
        subOrderDrinkService.PutSubOrderDrink(e);
        return subOrderDrinkService.FindSubOrderDrink(e.getId());
    }

    @GetMapping("/{id}")
    public SubOrderDrink findSubOrder(@PathVariable Long id) {
        return subOrderDrinkService.FindSubOrderDrink(id);
    }
}
