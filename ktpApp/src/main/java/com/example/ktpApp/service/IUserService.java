package com.example.ktpApp.service;

import com.example.ktpApp.model.User;

public interface IUserService {
	public User insertUser(User user);
	public User loginUser(String email, String password);
}
