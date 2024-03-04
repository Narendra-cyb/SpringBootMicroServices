package com.client.component;

import java.net.URI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProviderConsumingComponent {
	
	
	@Autowired
	LoadBalancerClient client;
	
	public String getBillingInfo() {
		
		ServiceInstance instance = client.choose("BillingService");
		
		URI uri = instance.getUri();
		
		String url = uri.toString()+"/billing/api/bill/{amount}";
		
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, null, String.class,Map.of("amount",2490));
		
		String body = response.getBody();
		
		return body;
	}

}
