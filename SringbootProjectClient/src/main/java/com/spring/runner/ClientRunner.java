package com.spring.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


public class ClientRunner implements CommandLineRunner{

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${service.url}")
	private String url;

	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println(url);
//		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class,Map.of("id",1,"msg","Hey How are You"));
//		System.out.println("response body "+response.getBody());
//		System.out.println("response header "+response.getHeaders());
//		System.out.println("response body "+response.getStatusCode());
//		System.out.println("response body "+response.getStatusCodeValue());
//		
		
		
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String jsonBody = "{\"id\":1001,\"name\":\"Narendra\",\"add\":\"Regada\"}";
		HttpEntity<String> request = new HttpEntity<String>(jsonBody,headers);
		//send post using Response post entity
		ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
		//process object
		System.out.println("body "+response.getBody());
		System.out.println("headers "+response.getHeaders());
		System.out.println("status code "+response.getStatusCode());
		
		//send post using Response object Entity
		
		String response1 = restTemplate.postForObject(url, request, String.class);
		System.out.println("response using post for object"+response1);
		
	
	}

}
