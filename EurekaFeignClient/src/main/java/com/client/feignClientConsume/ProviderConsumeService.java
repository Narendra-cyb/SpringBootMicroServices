package com.client.feignClientConsume;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("BillingService")
public interface ProviderConsumeService {

	@GetMapping("/billing/api/bill/{amount}")
	public ResponseEntity<String> deleteUser(@PathVariable int amount);
}
