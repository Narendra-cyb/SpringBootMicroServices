package com.spring.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.entity.Actor;

public class ObjectMapperListRunner implements CommandLineRunner{

	
	@Value("${service.mapUrl2}")
	private String url;
	
	@Autowired
	private RestTemplate template;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, null, String.class);
		
		
		ObjectMapper object = new ObjectMapper();
		List<Actor> value = object.readValue(response.getBody(), new TypeReference<List<Actor>>() {});
		value.forEach(System.out::println);
		
	}
	
	/*
	@Value("${service.mapUrl}")
	private String url;

	@Autowired
	private RestTemplate template;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ResponseEntity<String> entity = template.exchange(url, HttpMethod.GET, null, String.class);
		
		System.out.println("body: "+entity.getBody());
		System.out.println("header: "+entity.getHeaders());
		ObjectMapper mapper = new ObjectMapper();
		Actor actor = mapper.readValue(entity.getBody(), Actor.class);
		System.out.println("json to object convertion data :: "+actor);
	}
	*/
	
	
}
