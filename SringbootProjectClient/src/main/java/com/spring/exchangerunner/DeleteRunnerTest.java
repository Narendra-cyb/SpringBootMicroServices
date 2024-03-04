package com.spring.exchangerunner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


public class DeleteRunnerTest implements CommandLineRunner{

	@Autowired
	private RestTemplate template;
	
	@Value("${service.deleteUrl}")
	private String url;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		ResponseEntity<String> exchange = template.exchange(url, HttpMethod.DELETE, null, String.class, Map.of("id",1));
		System.out.println(exchange.getBody());
		
		
	}

}
