package com.example.demo.service.inter;

import com.example.demo.entity.OrderItemEntity;

import java.util.List;

public interface IOrderItemService {

    public List<OrderItemEntity> GetORderItem();

    public void  PostOrderItem(OrderItemEntity e);
    public void  PutOrderItem(OrderItemEntity e);
    public void  DeleteOrderItem(Long id);
    public OrderItemEntity FindOrderItem(Long id);
}
