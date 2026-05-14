package com.example.demo.service.inter;

import com.example.demo.entity.TablesEntity;
import org.springframework.data.domain.Page;

public interface ITablesService {

    //public Page<ProductosEntity> getProductos(int page, int size);

    public Page<TablesEntity> GetTables(int page, int size);
    public void DeleteTables(Long id);
    public void PostTables(TablesEntity e);
    public void PutTables(TablesEntity e);
    public TablesEntity FindTables(Long id);
}
