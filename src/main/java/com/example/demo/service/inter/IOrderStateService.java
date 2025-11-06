package com.example.demo.service.inter;


import com.example.demo.entity.OrdersStateEntity;

import java.util.List;

public interface IOrderStateService {

    public List<OrdersStateEntity> GetOrdersState();
    public void PostOrdersState(OrdersStateEntity e);
    public void PutOrdersState(OrdersStateEntity e);
    public void DeleteOrdersState(Long id);
    public OrdersStateEntity FindOrdersState(Long id);
}
