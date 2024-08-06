package com.demo.user.mng.sys.serviceimpl;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import com.demo.user.mng.sys.dto.AuthRequestDto;
import com.demo.user.mng.sys.dto.RoleDto;
import com.demo.user.mng.sys.dto.UserDto;
import com.demo.user.mng.sys.entities.UserEntity;
import com.demo.user.mng.sys.mapper.ModelMapperService;
import com.demo.user.mng.sys.repository.UserRepository;
import com.demo.user.mng.sys.service.RoleService;
import com.demo.user.mng.sys.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	ModelMapperService modelMapperService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleService roleService;

	/**
	 * {@inheritDoc}
	 * 
	 * @throws Exception
	 */
	@Override
	public String login(AuthRequestDto authRequest) throws Exception {
		UserDto userDto = findByUserNameOrEmail(authRequest.getUsernameOrEmail(), authRequest.getUsernameOrEmail());
		if (Objects.isNull(userDto)) {
			throw new Exception("User Not found");
		} else if (!userDto.getPassword().equals(authRequest.getPassword())) {
			throw new Exception("Password does not match");
		}
		return "User Logged in Successfully";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDto saveUser(UserDto userDto) {
		UserEntity userEntity = modelMapperService.convertToType(userDto, UserEntity.class);
		return modelMapperService.convertToType(userRepository.save(userEntity), UserDto.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDto findByUserNameOrEmail(String userName, String email) {
		return modelMapperService.convertToType(userRepository.findByUserNameOrEmail(userName, email), UserDto.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDto findByEmail(String email) {
		return modelMapperService.convertToType(userRepository.findByEmail(email), UserDto.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean isUserNameExists(String userName) {
		return Objects.nonNull(userRepository.findByUserName(userName));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDto registerUser(UserDto userDtoRequest) throws Exception {
		if (Objects.nonNull(findByEmail(userDtoRequest.getEmail()))) {
			throw new Exception("User Already Exists");
		} else if (isUserNameExists(userDtoRequest.getUserName())) {
			throw new Exception("Username Already taken");
		} else if (!userDtoRequest.getPassword().equals(userDtoRequest.getConfirmPassword())) {
			throw new Exception("Password Does not match");
		}
		RoleDto roleDto = roleService.findByRoleName(userDtoRequest.getRole().getRoleName());
		if (Objects.isNull(roleDto)) {
			throw new Exception("UserRole Not Found");
		}
		UserDto userDto = UserDto.builder().firstName(userDtoRequest.getFirstName())
				.lastName(userDtoRequest.getLastName()).userName(userDtoRequest.getUserName())
				.email(userDtoRequest.getEmail()).password(userDtoRequest.getPassword())
				.confirmPassword(userDtoRequest.getConfirmPassword()).role(roleDto).build();

		return saveUser(userDto);
	}

}
