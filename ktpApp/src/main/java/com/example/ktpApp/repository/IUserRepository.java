package com.example.ktpApp.repository;

import com.example.ktpApp.model.User;

public interface IUserRepository {
	public User insertUser(User user);
	public User loginUser (String email, String password);

}
