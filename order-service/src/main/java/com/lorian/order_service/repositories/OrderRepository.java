package com.lorian.order_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lorian.order_service.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
