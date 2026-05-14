package com.example.demo.service.inter;


import com.example.demo.entity.GeneralOrderEntity;

import java.util.List;

public interface IGeneralOrderService {
    public List<GeneralOrderEntity> GetGeneralOrder();
    public void PostGeneralOrder(GeneralOrderEntity e);
    public void PutGeneralOrder(GeneralOrderEntity e);
    public void DeleteGeneralOrder(Long id);
    public GeneralOrderEntity FindGeneralOrder(Long id);
    
}
