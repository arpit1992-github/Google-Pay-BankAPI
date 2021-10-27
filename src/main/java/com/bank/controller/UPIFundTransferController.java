package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.service.UPIFundTransferService;

@RestController
@Validated
@RequestMapping("/upifundTransfer")
public class UPIFundTransferController {
	@Autowired
	UPIFundTransferService upiFundTransferService;
	
	@Autowired
	Environment environment;

	@GetMapping("/port")
	public String getPortNo() {
		String port = environment.getProperty("local.server.port");
		return "From Order app : " + port;
	}
	
	
	@PostMapping("/transaction")
	public String fundTransferByMobNumber(@RequestParam("amount")double amount,@RequestParam("toMobileNumber") String toMobileNumber,@RequestParam("fromMobileNumber") String fromMobileNumber) {
		 String message = upiFundTransferService.fundTransferByMobile(amount, toMobileNumber, fromMobileNumber);
		 return message;
	}
}
