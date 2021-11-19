package com.springboot.eureka.client.payment.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment-service")

public class PaymentController {

	@GetMapping("/paymentStatus/{id}")
	public String paymentStatus(@PathVariable("id") int id ) {
		return "Payment Successful Done with  "+id;
	}
}
