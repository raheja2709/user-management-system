package com.demo.user.mng.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.mng.sys.constants.ApiPathConstants;
import com.demo.user.mng.sys.dto.AuthRequestDto;
import com.demo.user.mng.sys.dto.UserDto;
import com.demo.user.mng.sys.service.UserService;

@RestController
@RequestMapping(ApiPathConstants.AUTH)
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping(ApiPathConstants.LOGIN)
	public ResponseEntity<Object> authenticateAndGetToken(@RequestBody AuthRequestDto authRequest) throws Exception {
		return new ResponseEntity<>(userService.login(authRequest), HttpStatus.OK);
	}

	@PostMapping(ApiPathConstants.REGISTER)
	public ResponseEntity<Object> register(@RequestBody UserDto userDto) throws Exception {
		return new ResponseEntity<Object>(userService.registerUser(userDto), HttpStatus.OK);
	}

}
