package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceimplementation implements UserService{
    @Autowired
	UserRepository repo;
	@Override
	public String adduser(Users user) {
		repo.save(user);
		return "User Added successfully";
	}
	@Override
	public boolean checkEmail(String email) {
		
		return repo.existsByEmail(email);   
	}
	@Override
	public boolean validate(String email, String password) {
		if(repo.existsByEmail(email)) {
			Users u=repo.getByEmail(email);
			String dbPassword=u.getPassword();
			if(password.equals(dbPassword)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	@Override
	public String getUserRole(String email) {
		Users u=repo.getByEmail(email);
		return u.getRole();
	}
	
} 
