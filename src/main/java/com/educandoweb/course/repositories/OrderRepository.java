package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.Order;


import org.springframework.data.jpa.repository.JpaRepository;

//Não é obrigatorio colocar a anotation pois ela é herdada do JpaReposytory
public interface OrderRepository extends JpaRepository <Order, Long> {

}
