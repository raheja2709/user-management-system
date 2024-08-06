package com.demo.user.mng.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.user.mng.sys.entities.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

	RoleEntity findByRoleName(String roleName);

}
