package com.educandoweb.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    private static final long seriaVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd-'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getUser() {
        return client;
    }

    public void setUser(User user) {
        this.client = user;
    }

    public Order() {

    }

    public Order(Long id, Instant moment, User user) {
        this.id = id;
        this.moment = moment;
        this.client = user;
    }
}
