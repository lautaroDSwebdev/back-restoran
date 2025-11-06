package com.example.demo.controllers;


import com.example.demo.entity.OrderItemEntity;
import com.example.demo.service.Impl.OrdersItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-item")
public class OrderItemController {


    @Autowired
    private OrdersItemServiceImpl order_service;


    @GetMapping
    public List<OrderItemEntity> GetOrderItem(){
        List<OrderItemEntity> get_orders = order_service.GetORderItem();
        return get_orders;
    }

    @DeleteMapping("/{id}")
    public String DeleteOrderItem(@PathVariable Long id){
        order_service.DeleteOrderItem(id);
        return "orden eliminada";
    }
    @PostMapping
    public String  PostOrderItem(@RequestBody OrderItemEntity e){
        order_service.PostOrderItem(e);
        return "orden item creada";
    }

    @PutMapping
    public OrderItemEntity PutOrderItem(@RequestBody OrderItemEntity e){
        order_service.PutOrderItem(e);
        return order_service.FindOrderItem(e.getId());
    }

}
