package com.duongnv30.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duongnv30.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
	UserEntity findOneByUserNameAndStatus(String userName, int Status);
}
