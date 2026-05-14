package com.example.demo.controllers;

import com.example.demo.entity.GeneralOrderEntity;
import com.example.demo.service.Impl.GeneralOrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
 @RequestMapping("/general-order")
public class GeneralOrderController {
    
    @Autowired
    private GeneralOrderServiceImpl gen_order_serv;

    @GetMapping
    public List<GeneralOrderEntity> GetGeneralOrder(){
        return  gen_order_serv.GetGeneralOrder();
    }

    @PostMapping
    public String PostGeneralOrder(@RequestBody GeneralOrderEntity e){
        gen_order_serv.PostGeneralOrder(e);
        return "orden general creada ";
    }

    @PutMapping
    public GeneralOrderEntity PutGeneralOrder(@RequestBody GeneralOrderEntity e){
        gen_order_serv.PutGeneralOrder(e);
        return gen_order_serv.FindGeneralOrder(e.getId());
    }

    @DeleteMapping("/{id}")
    public String DeleteGeneralOrder(@PathVariable Long id){
        gen_order_serv.DeleteGeneralOrder(id);
        return "orden general  eliminada";
    }
    
    
}
