package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Não é obrigatorio colocar a anotation pois ela é herdada do JpaReposytory
public interface ProductRepository extends JpaRepository <Product, Long> {

}
