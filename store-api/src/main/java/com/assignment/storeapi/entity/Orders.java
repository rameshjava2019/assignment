package com.assignment.storeapi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId", updatable = false, nullable = false)
	private int orderId;
	
	@ManyToOne
	@JoinColumn(name="customerId")
	private Customer customer;
	
	@OneToOne(mappedBy="order", cascade=CascadeType.ALL)
	private Credits credits;
	
	@Column
	Integer amount;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Credits getCredits() {
		return credits;
	}

	public void setCredits(Credits credits) {
		this.credits = credits;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
	
	

}
