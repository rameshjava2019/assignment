package com.assignment.storeapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.storeapi.model.CreditRequest;
import com.assignment.storeapi.model.CreditResponse;
import com.assignment.storeapi.service.PurchaseService;

@RestController
@RequestMapping("/store")
public class StoreController {

	@Autowired
	PurchaseService purchaseService;

	@GetMapping("/creditpoints/get/{customerId}")
	ResponseEntity<CreditResponse> getCredits(@PathVariable("customerId") String customerId) {
		CreditResponse response = purchaseService.getCredits(customerId);
		return new ResponseEntity<CreditResponse>(response, HttpStatus.OK);

	}

	@PostMapping("/purchase")
	ResponseEntity<CreditResponse> purchase(@RequestBody CreditRequest creditRequest) {
		CreditResponse response = purchaseService.makePurchase(creditRequest);
		return new ResponseEntity<CreditResponse>(response, HttpStatus.OK);
	}
}
