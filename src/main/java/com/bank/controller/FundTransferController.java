package com.bank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.FundTransferRequestDto;
import com.bank.service.FundTransferService;

@RestController
@Validated
@RequestMapping("/fundTransfer")
public class FundTransferController {


	@Autowired
	FundTransferService fundTransferService;
	
	@PostMapping("/transfer")
	public ResponseEntity<String> createUser(@Valid @RequestBody FundTransferRequestDto userRequest){
		       String message=fundTransferService.fundTransfer(userRequest);
		       return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}
