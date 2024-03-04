package com.spring.runner;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ObjectMapperMapRunner implements CommandLineRunner{

	
	@Autowired
	private RestTemplate template;
	@Override
	public void run(String... args) throws Exception {
		String url = "http://localhost:8080/service/request3";
		ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, null, String.class);

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> map = mapper.readValue(response.getBody(), new TypeReference<Map<String,Object>>(){});		
		
		System.out.println(map);
	}

}
