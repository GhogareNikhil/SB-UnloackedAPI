package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bindings.UnlockAccRequest;
import com.example.demo.service.UnlockAccService;

@RestController
public class UnlockAccRestController {

	@Autowired
	private UnlockAccService unService;
	
	@PostMapping("unlockaccunt")
	public String unlockAccount(@RequestBody UnlockAccRequest unRequest) {
		return unService.UnlockAccount(unRequest);
		 
	}
}
