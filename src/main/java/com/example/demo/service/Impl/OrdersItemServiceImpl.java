package com.example.demo.service.Impl;

import com.example.demo.entity.OrderItemEntity;
import com.example.demo.repository.OrdetItemRepo;
import com.example.demo.service.inter.IOrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersItemServiceImpl implements IOrderItemService {

    @Autowired
    private OrdetItemRepo order_repo;

    @Override
    public List<OrderItemEntity> GetORderItem() {
        List<OrderItemEntity> get_orders = order_repo.findAll();
        return get_orders ;
    }

    @Override
    public void PostOrderItem(OrderItemEntity e) {
        order_repo.save(e);
    }

    @Override
    public void PutOrderItem(OrderItemEntity e) {
        this.PostOrderItem(e);
    }

    @Override
    public void DeleteOrderItem(Long id) {
        order_repo.deleteById(id);
    }

    @Override
    public OrderItemEntity FindOrderItem(Long id) {
        OrderItemEntity find_order = order_repo.findById(id).orElse(null);
        return find_order;
    }
}
