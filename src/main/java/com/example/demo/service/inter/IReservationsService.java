package com.example.demo.service.inter;

import com.example.demo.entity.ReservationsEntity;

import java.util.List;

public interface IReservationsService {

    public List<ReservationsEntity> GetReservations();

    public void  PostRevervarions(ReservationsEntity e);

    public void DeleteReservations(Long id);

    public void  PutRevervarions(ReservationsEntity e);

    public ReservationsEntity FindReservations(Long id);
}
