package com.crs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crs.bean.Response;
import com.crs.bean.User;
import com.crs.service.LoginService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	
	@PostMapping("/login")
	public ResponseEntity<Response> performLogin(@RequestBody User user) {
		Response res=service.login(user);
			return ResponseEntity.ok(res);
	}

}
