package com.spring.template.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spring.template.model.PaymentMethod;
import com.spring.template.service.PaymentMethodService;


@RestController
@RequestMapping(value="restTemplate")
public class RestTemplatePaymentMethodController {
	
	@Autowired PaymentMethodService pService;
	@Autowired Environment environment;
	
	
	//http://localhost:9095/restTemplate/paymentMethod
	@GetMapping(value="/paymentMethod")
	public ResponseEntity<List<PaymentMethod>> getAllPaymentMethod() throws Exception
	{
		List<PaymentMethod> pList=pService.getAllPaymentMethod();
		ResponseEntity<List<PaymentMethod>> response=new ResponseEntity<List<PaymentMethod>>(pList,HttpStatus.OK);
		return response;
	}
	
	
	//http://localhost:9095/restTemplate/paymentMethod/card
	@GetMapping(value="/paymentMethod/{methodName}")
	public ResponseEntity<PaymentMethod> getPaymentMethod(@PathVariable String methodName) throws Exception
	{
		try {
			PaymentMethod pMethod=pService.getPaymentMethod(methodName);	
			ResponseEntity<PaymentMethod> response=new ResponseEntity<PaymentMethod>(pMethod,HttpStatus.OK);
			return response;
			}catch(Exception e)
			{
				throw new  ResponseStatusException(HttpStatus.NOT_FOUND,environment.getProperty(e.getMessage()),e);
			}
		
	}
	
	
	@PostMapping(value="/paymentMethod")
	public ResponseEntity<String> addPaymentMethod(@RequestBody PaymentMethod paymentmethod) throws Exception
	{
		try {
			pService.addPaymentMethod(paymentmethod);	
			String message="Added Successfully";
			return new ResponseEntity<String>(message,HttpStatus.CREATED);
			}catch(Exception e)
			{
				throw new  ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()),e);
			}
	}
	
	
	@PutMapping(value="/paymentMethod/{methodName}")
	public ResponseEntity<String> updatePaymentMethod(@PathVariable String methodName, @RequestBody PaymentMethod method) throws Exception
	{
		pService.updatePaymentMethod(methodName,method);
		String message="Updated Successfully";
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping(value="/paymentMethod/{methodName}")
	public ResponseEntity<String> deletePaymentMethod(@PathVariable String methodName) throws Exception
	{
		pService.deletePaymentMethod(methodName);
		String message="Deleted Successfully";
		return new ResponseEntity<String>(message,HttpStatus.ACCEPTED);
	}

}
