package com.assignment.storeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.storeapi.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer>{

}
