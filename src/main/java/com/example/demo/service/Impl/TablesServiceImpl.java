package com.example.demo.service.Impl;

import com.example.demo.entity.TablesEntity;
import com.example.demo.repository.TablesRepo;
import com.example.demo.service.inter.ITablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TablesServiceImpl implements ITablesService {

    @Autowired
    private TablesRepo tables_repo;

    @Override
    public Page<TablesEntity> GetTables(int page, int size) {
        Pageable pagin_prod = PageRequest.of(page, size);
        return tables_repo.findAll(pagin_prod);
    }
    @Override
    public void DeleteTables(Long id) {
        tables_repo.deleteById(id);
    }

    @Override
    public void PostTables(TablesEntity e) {
        tables_repo.save(e);
    }

    @Override
    public void PutTables(TablesEntity e) {
        this.PostTables(e);
    }

    @Override
    public TablesEntity FindTables(Long id) {
        TablesEntity fint_tables = tables_repo.findById(id).orElse(null);
        return fint_tables;
    }
}
