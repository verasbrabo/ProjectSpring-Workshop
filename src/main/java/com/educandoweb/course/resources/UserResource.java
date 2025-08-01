package com.educandoweb.course.resources;

import com.educandoweb.course.entities.User;

import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.UserService;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;


      @GetMapping
      public ResponseEntity<List<User>>findAll(){
          List<User> list = service.findAll();

          return ResponseEntity.ok().body(list);
      }

      @GetMapping(value = "/{id}")
      public ResponseEntity<User> findById(@PathVariable Long id){
          User u = service.findById(id);
          return ResponseEntity.ok().body(u);
    }

    @PostMapping
    public ResponseEntity<User> insert (@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return  ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
          service.delete(id);
          return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update (@PathVariable Long id, @RequestBody User obj){
          try {
              obj = service.update(id, obj);
              return ResponseEntity.ok().body(obj);
          }catch (EntityNotFoundException e){
              throw new ResourceNotFoundException(id);
          }

    }

}
