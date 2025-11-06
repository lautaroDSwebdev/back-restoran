package com.example.demo.controllers;

import com.example.demo.entity.InventoryItemEntity;
import com.example.demo.service.Impl.InventoryItemImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory-item")
public class InventiryItemController {

    @Autowired
    private InventoryItemImpl inven_serv;

    @GetMapping
    public List<InventoryItemEntity> GetInventory() {
        List<InventoryItemEntity> inv_get = inven_serv.GetInventiryItem();
        return inv_get;
    }

    @PostMapping
    public String PostInventory(@RequestBody InventoryItemEntity e) {
        inven_serv.PostInventoryItem(e);
        return "inventario de ingredientes hecho";
    }

    @PutMapping
    public InventoryItemEntity PutInventory(@RequestBody InventoryItemEntity e) {
        inven_serv.PostInventoryItem(e);
        return inven_serv.FindInventoryItem(e.getId());
    }

    @DeleteMapping("/{id}")
    public String PutInventory(@PathVariable Long id) {
        inven_serv.DeleteInventoryItem(id);
        return "Inventario eliminado";
    }


}
