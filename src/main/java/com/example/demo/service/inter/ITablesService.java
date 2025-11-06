package com.example.demo.service.inter;

import com.example.demo.entity.TablesRestaurantEntity;

import java.util.List;

public interface ITablesService {

    public List<TablesRestaurantEntity> GetTables();
    public void DeleteTables(Long id);
    public void PostTables(TablesRestaurantEntity e);
    public void PutTables(TablesRestaurantEntity e);
    public TablesRestaurantEntity FindTables(Long id);
}
