package com.demo.user.mng.sys.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequestDto {

	public String usernameOrEmail;
	public String password;

}
