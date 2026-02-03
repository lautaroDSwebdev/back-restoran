package com.example.demo.service.inter;

import com.example.demo.entity.TablesRestaurantEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ITablesService {

    //public Page<ProductosEntity> getProductos(int page, int size);

    public Page<TablesRestaurantEntity> GetTables(int page, int size);
    public void DeleteTables(Long id);
    public void PostTables(TablesRestaurantEntity e);
    public void PutTables(TablesRestaurantEntity e);
    public TablesRestaurantEntity FindTables(Long id);
}
