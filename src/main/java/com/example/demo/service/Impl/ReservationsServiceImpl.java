package com.example.demo.service.Impl;

import com.example.demo.entity.ReservationsEntity;
import com.example.demo.repository.ReservationsRepo;
import com.example.demo.service.inter.IReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationsServiceImpl implements IReservationsService {


    @Autowired
    private ReservationsRepo res_repo;

    @Override
    public List<ReservationsEntity> GetReservations() {
        List<ReservationsEntity> get_reserv = res_repo.findAll();
        return get_reserv;
    }

    @Override
    public void PostRevervarions(ReservationsEntity e) {
        res_repo.save(e);
    }

    @Override
    public void DeleteReservations(Long id) {
        res_repo.deleteById(id);
    }

    @Override
    public void PutRevervarions(ReservationsEntity e) {
        this.PostRevervarions(e);
    }

    @Override
    public ReservationsEntity FindReservations(Long id) {
        ReservationsEntity res_find = res_repo.findById(id).orElse(null);
        return res_find;
    }
}
