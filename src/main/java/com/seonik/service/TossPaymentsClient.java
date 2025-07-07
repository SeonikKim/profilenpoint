package com.seonik.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Component
public class TossPaymentsClient {
	private final RestTemplate restTemplate = new RestTemplate();
	private final String secretKey;

	public TossPaymentsClient(@Value("${tossPayments.secretKey}") String secretKey) {
		this.secretKey = secretKey;
	}

	public void confirm(String paymentKey, String orderId, int amount) {
		String url = "https://api.tosspayments.com/v1/payments/confirm";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String auth = Base64.getEncoder().encodeToString((secretKey + ":").getBytes(StandardCharsets.UTF_8));
		headers.set("Authorization", "Basic " + auth);

		Map<String, Object> body = new HashMap<>();
		body.put("paymentKey", paymentKey);
		body.put("orderId", orderId);
		body.put("amount", amount);

		HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
		ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
		if (!response.getStatusCode().is2xxSuccessful()) {
			throw new IllegalStateException("Payment confirmation failed: " + response.getStatusCode());
		}
	}
}