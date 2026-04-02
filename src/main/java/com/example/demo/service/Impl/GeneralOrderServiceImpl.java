package com.example.demo.service.Impl;

import com.example.demo.entity.GeneralOrderEntity;
import com.example.demo.repository.GeneralOrderRepo;
import com.example.demo.service.inter.IGeneralOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralOrderServiceImpl implements IGeneralOrderService {

    @Autowired
    private GeneralOrderRepo general_ord_repo;

    @Override
    public List<GeneralOrderEntity> GetGeneralOrder() {
        return general_ord_repo.findAll();
    }

    @Override
    public void PostGeneralOrder(GeneralOrderEntity e) {
        general_ord_repo.save(e);
    }

    @Override
    public void PutGeneralOrder(GeneralOrderEntity e) {
        this.PostGeneralOrder(e);
    }

    @Override
    public void DeleteGeneralOrder(Long id) {
        general_ord_repo.deleteById(id);
    }

    @Override
    public GeneralOrderEntity FindGeneralOrder(Long id) {
        return general_ord_repo.findById(id).orElse(null);

    }
}
