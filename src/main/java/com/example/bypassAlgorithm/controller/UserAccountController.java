package com.example.bypassAlgorithm.controller;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.example.bypassAlgorithm.entity.LoginAccount;
//import com.example.bypassAlgorithm.entity.UserAccount;
import com.example.bypassAlgorithm.repository.UserAccountRepository;

@RestController
public class UserAccountController {
	@Autowired
	UserAccountRepository userAccountRepository;
	
//	private List<UserAccount> getAccounts(){
//		
//	}
	
//	@PostMapping("/postlogin")
//	private String getUser(@RequestParam String email) {
//		UserAccount ua = userAccountRepository.findByEmailContaining(email);
////		Long id = (long) 1;
////		Optional<UserAccount> tutorialData = userAccountRepository.findById(id);
////		 UserAccount ua = tutorialData.get();
////		Optional <UserAccount>  = userAccountRepository.findById((long) 1);
//		System.out.println("%%%%%%%%%%%%%%%%%%%%%5");
//		System.out.println(email);
//		System.out.println(ua.getId());
//		return "Check console post login";
//	}
//	
//	@PostMapping("/userLogin")
//	private String login(@RequestBody LoginAccount loginAccount) {
//		System.out.println(loginAccount.getEmail());
//		return "check console";
//	}
}
