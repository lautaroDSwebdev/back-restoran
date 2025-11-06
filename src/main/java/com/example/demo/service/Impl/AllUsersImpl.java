//package com.example.demo.service.Impl;
//
//import com.example.demo.entity.UserEntity;
//import com.example.demo.repository.AllUsersRepo;
//import com.example.demo.service.inter.IUsersService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AllUsersImpl implements IUsersService {
//
//    @Autowired
//    private AllUsersRepo allusers_repo;
//
//    @Override
//    public Page<UserEntity> GetAllUsers(int page, int size) {
//        Pageable getall_users = PageRequest.of(page, size);
//            return allusers_repo.findAll(getall_users);
//    }
//
//    @Override
//    public void DeleteUser(Long id) {
//         allusers_repo.deleteById(id);
//    }
//}
