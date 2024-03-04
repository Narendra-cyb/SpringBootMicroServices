package com.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.feignClientConsume.ProviderConsumeService;

@RestController
@RequestMapping("/shopping/api")
public class FeignConsumerController {

	
	@Autowired
	ProviderConsumeService service;
	@GetMapping("/cart/{amount}")
	public ResponseEntity<String> getBillFromProvider(@PathVariable int amount){
		ResponseEntity<String> deleteUser = service.deleteUser(amount);
		return deleteUser;
	}
}
