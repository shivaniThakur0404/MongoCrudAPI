package com.demo.Mongodemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Mongodemo.model.User;
import com.demo.Mongodemo.repository.UserRepository;
import com.demo.Mongodemo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	 @Autowired
	 UserService service;
	 
	 @Autowired 
	 UserRepository userRepository;
	 
	 @RequestMapping(value="/create",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<User> create(@RequestBody User user) {
		 if(user==null)
		 {
			 return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		 }
	        User u=service.createUser(user);
	        System.out.println(u.getName()+"nameeeeeeee");
	        return new ResponseEntity<User>(u,HttpStatus.OK);
	    }

	    @RequestMapping(value = "/read/{id}") 
	    public ResponseEntity<User> read(@PathVariable String id) {
	         User u=service.readUser(id);
	         return new ResponseEntity<User>(u,HttpStatus.OK);
	    }

	    @RequestMapping(value="/update",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<User> update(@RequestBody User user) {
	     User s=   service.updateUser(user);
	        return new ResponseEntity<User>(s,HttpStatus.OK);
	    }

	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE) 
	    public ResponseEntity<String> delete(@PathVariable String id) {
	        String s=service.deleteById(id); 
	        return new ResponseEntity<String>(s,HttpStatus.OK);
	    }

}
