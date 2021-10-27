package com.bank.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.BankStatementDto;
import com.bank.service.BankStatementService;

@RestController
@Validated
@RequestMapping("/bankstatement")
public class BankStatementController {

	@Autowired
	BankStatementService bankStatementService;
	
	@GetMapping("/trasaction")
	public ResponseEntity<List<BankStatementDto>> getBankStatement( @RequestParam("date")String date,@RequestParam("account")String account){
		List<BankStatementDto> statements=bankStatementService.getBankStatement(date,account);
		       return new ResponseEntity<List<BankStatementDto>>(statements,HttpStatus.OK);
	}
}
