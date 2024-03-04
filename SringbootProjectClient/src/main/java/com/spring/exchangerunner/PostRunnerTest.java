package com.spring.exchangerunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PostRunnerTest implements CommandLineRunner{
	
	@Autowired
	private RestTemplate template;
	@Value("${service.postUrl}")
	private String url;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String body = "{\"id\":200,\"name\":\"Naren\",\"add\":\"bbsr\"}";
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(body,header);
		ResponseEntity<String> responseEntity = template.exchange(url, HttpMethod.POST, entity, String.class);
		System.out.println(responseEntity.getBody());
		System.out.println(responseEntity.getHeaders());
		System.out.println(responseEntity.getStatusCode());
	}
}
