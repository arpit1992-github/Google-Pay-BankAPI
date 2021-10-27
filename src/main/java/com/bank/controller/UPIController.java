package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.service.UPICustomerService;

@RestController
@Validated
@RequestMapping("/upi")
public class UPIController {
	@Autowired
	UPICustomerService upiCustomerService;
	
	@Autowired
	Environment environment;

	@GetMapping("/port")
	public String getPortNo() {
		String port = environment.getProperty("local.server.port");
		return "From Order app : " + port;
	}
	
	@GetMapping("/checkMobStatus/{mobNumber}")
	public ResponseEntity<Boolean> checkUserRegMobNumber(@PathVariable("mobNumber") String mobileNumber){ 
		
		       boolean message=upiCustomerService.checkUserRegMob(mobileNumber);
		       System.out.println(message);
		       return new ResponseEntity<Boolean>(message,HttpStatus.OK);
	}
}
