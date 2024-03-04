package com.spring.exchangerunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


public class GetRunnerTest implements CommandLineRunner{
	
	@Autowired
	private RestTemplate template;
	
	@Value("${service.url}")
	private String url;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ResponseEntity<String> responseEntity = template.exchange(url, HttpMethod.GET, null, String.class);
		System.out.println("body "+responseEntity.getBody());
		System.out.println("headers "+responseEntity.getHeaders());
		System.out.println("");
		
	}
	
	
}
