package com.educandoweb.course.services;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;


    public Order findById (long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

    public List<Order> findAll(){
        return repository.findAll();
    }
}
