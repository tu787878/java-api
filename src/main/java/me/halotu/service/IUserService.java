package me.halotu.service;

import java.util.List;

import me.halotu.model.UserModel;

public interface IUserService {
	void testConnection();
	UserModel findOne(Long id);
	UserModel addUser(UserModel user);
	List<UserModel> getUsers();
	UserModel update(UserModel userToUpdate);
}
