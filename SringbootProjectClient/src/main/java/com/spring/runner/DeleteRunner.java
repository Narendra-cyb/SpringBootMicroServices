package com.spring.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


public class DeleteRunner implements CommandLineRunner{
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${service.deleteUrl}")
	private String deleteUrl;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		restTemplate.delete(deleteUrl,Map.of("id",1));
		System.out.println("deletion is completed");
		
	}

	
	
}
