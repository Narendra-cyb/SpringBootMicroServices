package com.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing/api")
public class ProviderController {
	
	
	@Value("${server.port}")
	private int portNo;
	
	
	@Value("${eureka.instance.instance-id}")
	private String instanceId;

	
	@GetMapping("/bill/{amount}")
	public ResponseEntity<String> deleteUser(@PathVariable int amount) {
		return new ResponseEntity<String>("amount of your product is::: "+amount+" with port no. "+portNo+" with instanceID "+instanceId, HttpStatus.OK);
	}
}
