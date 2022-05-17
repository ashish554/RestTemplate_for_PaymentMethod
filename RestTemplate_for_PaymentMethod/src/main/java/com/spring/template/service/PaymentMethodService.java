package com.spring.template.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.spring.template.model.PaymentMethod;

@Component
public class PaymentMethodService {

	public List<PaymentMethod> getAllPaymentMethod() {
		String URL="http://localhost:9090/restApi/paymentMethod";
		RestTemplate template= new RestTemplate();
		ResponseEntity<PaymentMethod[]> response= template.getForEntity(URL, PaymentMethod[].class);
		PaymentMethod[] list=response.getBody();
		return Arrays.asList(list);
	}

	public PaymentMethod getPaymentMethod(String methodName) {
		String URL="http://localhost:9090/restApi/paymentMethod/{methodName}";
		RestTemplate template= new RestTemplate();
		PaymentMethod method= template.getForObject(URL, PaymentMethod.class, methodName);
		return method;
	}

	public void addPaymentMethod(PaymentMethod paymentmethod) {
		String URL="http://localhost:9090/restApi/paymentMethod";
		RestTemplate template= new RestTemplate();
		template.postForObject(URL, paymentmethod, String.class);
	}

	public void updatePaymentMethod(String methodName, PaymentMethod method) {
		String URL="http://localhost:9090/restApi/paymentMethod/{methodName}";
		RestTemplate template= new RestTemplate();
		template.put(URL, method, methodName);
	}

	public void deletePaymentMethod(String methodName) {
		String URL="http://localhost:9090/restApi/paymentMethod/{methodName}";
		RestTemplate template= new RestTemplate();
		template.delete(URL, methodName);
		
	}

}
