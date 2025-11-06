package com.example.demo.service.inter;

import com.example.demo.entity.InventoryItemEntity;

import java.util.List;

public interface IinventoryItemService {

    public List<InventoryItemEntity> GetInventiryItem();
    public void PostInventoryItem(InventoryItemEntity e);
    public void PutInventoryItem(InventoryItemEntity e);
    public void DeleteInventoryItem(Long id);
    public InventoryItemEntity FindInventoryItem(Long id);
}
