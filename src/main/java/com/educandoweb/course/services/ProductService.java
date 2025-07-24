package com.educandoweb.course.services;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;


    public Product findById (long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

    public List<Product> findAll(){
        return repository.findAll();
    }
}
