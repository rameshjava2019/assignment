package com.assignment.storeapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.storeapi.entity.Credits;

@Repository
public interface CreditRepository extends JpaRepository<Credits, Integer> {

	List<Credits> findByOrder_Customer_CustomerId(int customerId);
}
