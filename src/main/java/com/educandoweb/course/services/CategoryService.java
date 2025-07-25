package com.educandoweb.course.services;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;


    public Category findById (long id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }

    public List<Category> findAll(){
        return repository.findAll();
    }
}
