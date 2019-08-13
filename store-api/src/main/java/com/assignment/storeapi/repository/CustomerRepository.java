package com.assignment.storeapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.storeapi.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
