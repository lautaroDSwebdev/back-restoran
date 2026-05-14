package com.example.demo.controllers;

import com.example.demo.entity.TablesEntity;
import com.example.demo.service.Impl.TablesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tables")
public class TablesController {

    @Autowired
    private TablesServiceImpl tables_serv;


    @GetMapping
    public  ResponseEntity<Page<TablesEntity>> GetTables(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Page<TablesEntity> tables_get = tables_serv.GetTables(page, size);

        return ResponseEntity.ok(tables_get);
    }


    @PostMapping
    public String PostTables(@RequestBody TablesEntity e){
        tables_serv.PostTables(e);
        return "mesa creada";
    }

    @PutMapping
    public TablesEntity PutTables(@RequestBody TablesEntity e){
        tables_serv.PutTables(e);
        return tables_serv.FindTables(e.getId());
    }
    @DeleteMapping("/{id}")
    public String DeleteTables(@PathVariable Long id){
        tables_serv.DeleteTables(id);
        return "Mesada eliminada";
    }
}
