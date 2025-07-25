package com.educandoweb.course.repositories;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

//Não é obrigatorio colocar a anotation pois ela é herdada do JpaReposytory
public interface OrderItemsRepository extends JpaRepository <OrderItem, Long> {

}
