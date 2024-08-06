package com.demo.user.mng.sys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleDto {

	@JsonProperty(access = Access.READ_ONLY)
	public int id;
	public String roleName;

}
