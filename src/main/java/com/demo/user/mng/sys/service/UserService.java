package com.demo.user.mng.sys.service;

import com.demo.user.mng.sys.dto.AuthRequestDto;
import com.demo.user.mng.sys.dto.UserDto;

public interface UserService {

	public String login(AuthRequestDto authRequest) throws Exception;

	public UserDto registerUser(UserDto userRequestDto) throws Exception;

	public UserDto saveUser(UserDto userDto);

	public UserDto findByUserNameOrEmail(String userName, String email);

	public UserDto findByEmail(String email);

	public Boolean isUserNameExists(String userName);

}
