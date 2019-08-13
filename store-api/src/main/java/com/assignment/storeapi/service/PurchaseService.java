package com.assignment.storeapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.assignment.storeapi.entity.Credits;
import com.assignment.storeapi.entity.Customer;
import com.assignment.storeapi.entity.Orders;
import com.assignment.storeapi.model.CreditRequest;
import com.assignment.storeapi.model.CreditResponse;
import com.assignment.storeapi.repository.CreditRepository;
import com.assignment.storeapi.repository.CustomerRepository;
import com.assignment.storeapi.repository.OrderRepository;

@Service
public class PurchaseService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	CreditRepository creditRepository;

	@Autowired
	OrderRepository orderRepository;

	@Transactional
	public CreditResponse makePurchase(CreditRequest creditRequest) {
		Orders orders = new Orders();
		Credits credits = new Credits();
		CreditResponse response = new CreditResponse();
		Customer customer = customerRepository.getOne(Integer.parseInt(creditRequest.getCustomerId()));
		orders.setCustomer(customer);
		credits.setPoints(calculateReward(creditRequest.getAmount()));
		orders.setAmount(creditRequest.getAmount());
		orders.setCredits(credits);
		credits.setOrder(orders);
		orders = orderRepository.save(orders);
		response.setCreditPoints(orders.getCredits().getPoints());
		response.setCustomerName(customer.getCustomerName());
		response.setCustomerId(String.valueOf(customer.getCustomerId()));
		return response;
	}

	public CreditResponse getCredits(String customerId) {
		Customer customer = customerRepository.getOne(Integer.parseInt(customerId));
		List<Credits> credits = creditRepository.findByOrder_Customer_CustomerId(Integer.parseInt(customerId));
		int sum = credits.stream().mapToInt(cred -> cred.getPoints()).sum();
		CreditResponse response = new CreditResponse();
		response.setCreditPoints(sum);
		response.setCustomerName(customer.getCustomerName());
		response.setCustomerId(String.valueOf(customer.getCustomerId()));
		return response;
	}

	private int calculateReward(int amount) {
		if (amount <= 50) {
			return 0;
		} else if (amount <= 100) {
			return amount - 50;
		} else {
			int dblPts = amount - 100;
			return 50 + 2 * dblPts;
		}
	}

}


