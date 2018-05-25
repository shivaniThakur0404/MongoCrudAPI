package com.demo.Mongodemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Mongodemo.model.User;
import com.demo.Mongodemo.repository.UserRepository;

@Service
public class UserService {
	 @Autowired
	 UserRepository userRepository;
	 
	 public User createUser( User user) {
	      
	      return userRepository.save(user);
	    }
	 
	 public User readUser(String id) {
	        return userRepository.findOne(id);
	    }
	 
	 public User updateUser( User user) {
	      return  userRepository.save(user);
	    }
	 public String deleteById( String id) {
	         userRepository.delete(id); 
	         return "Deleted";
	    }
}
