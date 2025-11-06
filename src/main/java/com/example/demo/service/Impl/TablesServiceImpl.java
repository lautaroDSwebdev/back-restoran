package com.example.demo.service.Impl;

import com.example.demo.entity.TablesRestaurantEntity;
import com.example.demo.repository.TablesRepo;
import com.example.demo.service.inter.ITablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TablesServiceImpl implements ITablesService {

    @Autowired
    private TablesRepo tables_repo;

    @Override
    public List<TablesRestaurantEntity> GetTables() {
        List<TablesRestaurantEntity> get_tables = tables_repo.findAll();
        return get_tables;
    }

    @Override
    public void DeleteTables(Long id) {
        tables_repo.deleteById(id);
    }

    @Override
    public void PostTables(TablesRestaurantEntity e) {
        tables_repo.save(e);
    }

    @Override
    public void PutTables(TablesRestaurantEntity e) {
        this.PostTables(e);
    }

    @Override
    public TablesRestaurantEntity FindTables(Long id) {
        TablesRestaurantEntity fint_tables = tables_repo.findById(id).orElse(null);
        return fint_tables;
    }
}
