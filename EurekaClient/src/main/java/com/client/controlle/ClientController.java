package com.client.controlle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.client.component.ProviderConsumingComponent;

@RestController
@RequestMapping("/shopping/api")
public class ClientController {

	@Autowired
	ProviderConsumingComponent client;
	
	@GetMapping("/cart")
	public ResponseEntity<String> fetchBillandDisplay(){
		
		String billingInfo = client.getBillingInfo();
		try {
			Thread.sleep(20000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(billingInfo,HttpStatus.OK);
	}
}
