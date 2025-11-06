package com.example.demo.service.Impl;

import com.example.demo.entity.InventoryItemEntity;
import com.example.demo.repository.InventoryItemRepo;
import com.example.demo.service.inter.IinventoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryItemImpl implements IinventoryItemService {

    @Autowired
    private InventoryItemRepo inventory_repo;



    @Override
    public List<InventoryItemEntity> GetInventiryItem() {
        List<InventoryItemEntity> get_inv = inventory_repo.findAll();
        return get_inv;
    }

    @Override
    public void PostInventoryItem(InventoryItemEntity e) {
        inventory_repo.save(e);
    }

    @Override
    public void PutInventoryItem(InventoryItemEntity e) {
        this.PostInventoryItem(e);
    }

    @Override
    public void DeleteInventoryItem(Long id) {
        inventory_repo.deleteById(id);
    }

    @Override
    public InventoryItemEntity FindInventoryItem(Long id) {
        InventoryItemEntity find_inv = inventory_repo.findById(id).orElse(null);
        return find_inv;
    }
}
