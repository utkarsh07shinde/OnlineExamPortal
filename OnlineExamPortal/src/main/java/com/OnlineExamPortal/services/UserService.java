package com.OnlineExamPortal.services;

import java.util.Optional;

import com.OnlineExamPortal.entity.User;

public interface UserService {

	public Optional<User> findByUsername(String username);
}
