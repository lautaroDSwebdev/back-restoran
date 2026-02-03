package com.example.demo.controllers;

import com.example.demo.entity.TablesRestaurantEntity;
import com.example.demo.service.Impl.TablesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TablesController {

    @Autowired
    private TablesServiceImpl tables_serv;


    @GetMapping
    public  ResponseEntity<Page<TablesRestaurantEntity>> GetTables(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Page<TablesRestaurantEntity> tables_get = tables_serv.GetTables(page, size);

        return ResponseEntity.ok(tables_get);
    }


    @PostMapping("/tables")
    public String PostTables(@RequestBody TablesRestaurantEntity e){
        tables_serv.PostTables(e);
        return "mesa creada";
    }

    @PutMapping("/tables")
    public TablesRestaurantEntity PutTables(@RequestBody TablesRestaurantEntity e){
        tables_serv.PutTables(e);
        return tables_serv.FindTables(e.getId());
    }
    @DeleteMapping("/tables/{id}")
    public String DeleteTables(@PathVariable Long id){
        tables_serv.DeleteTables(id);
        return "Mesada eliminada";
    }
}
