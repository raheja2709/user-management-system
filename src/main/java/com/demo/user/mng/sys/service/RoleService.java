package com.demo.user.mng.sys.service;

import com.demo.user.mng.sys.dto.RoleDto;

public interface RoleService {

	public RoleDto findByRoleName(String roleName);

}
