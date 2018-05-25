package com.demo.Mongodemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.Mongodemo.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	public User findOneByName(String name);
}
