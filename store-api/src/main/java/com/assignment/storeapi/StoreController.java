package com.assignment.storeapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {

	
	@GetMapping("/hello/{name}")
	String sayHello(@PathVariable("name")String name) {
		return "zhello "+name;
	}
}
