package com.demo.user.mng.sys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {

	@JsonProperty(access = Access.READ_ONLY)
	public Integer id;
	public String firstName;
	public String lastName;
	public String userName;
	public String email;
	@JsonProperty(access = Access.WRITE_ONLY)
	public String password;
	@JsonProperty(access = Access.WRITE_ONLY)
	public String confirmPassword;
	public RoleDto role;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(Integer id, String firstName, String lastName, String userName, String email, String password,
			String confirmPassword, RoleDto role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.role = role;
	}

}
