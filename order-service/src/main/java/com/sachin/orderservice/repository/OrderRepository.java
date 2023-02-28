package com.sachin.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sachin.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
