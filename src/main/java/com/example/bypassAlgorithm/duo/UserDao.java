package com.example.bypassAlgorithm.duo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.bypassAlgorithm.entity.UserAccount;

@Component
public interface UserDao extends JpaRepository<UserAccount, Long> {

}
