package com.demo.user.mng.sys.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.user.mng.sys.dto.RoleDto;
import com.demo.user.mng.sys.mapper.ModelMapperService;
import com.demo.user.mng.sys.repository.RoleRepository;
import com.demo.user.mng.sys.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	ModelMapperService modelMapperService;

	@Override
	public RoleDto findByRoleName(String roleName) {
		return modelMapperService.convertToType(roleRepository.findByRoleName(roleName), RoleDto.class);
	}

}
