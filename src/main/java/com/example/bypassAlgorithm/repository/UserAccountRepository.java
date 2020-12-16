package com.example.bypassAlgorithm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bypassAlgorithm.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
	
	UserAccount findByEmailContaining(String email);
}
