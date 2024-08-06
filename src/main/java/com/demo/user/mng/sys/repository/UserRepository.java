package com.demo.user.mng.sys.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.user.mng.sys.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	UserEntity findByUserNameOrEmail(String userName, String email);

	Optional<UserEntity> findByEmail(String email);

	UserEntity findByUserName(String userName);
}
