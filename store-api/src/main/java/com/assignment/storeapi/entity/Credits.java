package com.assignment.storeapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Credits {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "creditId", updatable = false, nullable = false)
	private int creditId;
	
	@Column
	private int points;
	
	@OneToOne
	@JoinColumn(name="orderId")
	private Orders order;

	public int getCreditId() {
		return creditId;
	}

	public void setCreditId(int creditId) {
		this.creditId = creditId;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}
	
	
}
