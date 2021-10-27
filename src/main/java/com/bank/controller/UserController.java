package com.bank.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.UserRequestDto;
import com.bank.service.UserService;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	Environment environment;

	@GetMapping("/port")
	public String getPortNo() {
		String port = environment.getProperty("local.server.port");
		return "From Order app : " + port;
	}
	
	@PostMapping("/creatUser")
	public ResponseEntity<String> createUser(@Valid @RequestBody UserRequestDto userRequest){
		      String message=null;
		       if(userRequest.getAge()<18) {
		    	   message="You are not aligible for Bank Account ! you should be atleast  18 year old ";
		    	   return new ResponseEntity<String>(message,HttpStatus.OK);
		       }
		        message=userService.createUserAccount(userRequest);
		       return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
}
