package me.halotu.dao;

import java.util.List;

import me.halotu.model.UserModel;

public interface IUserDAO {
	UserModel findOne(Long id);
	UserModel addUser(UserModel user);
	List<UserModel> getUsers();
	UserModel update(UserModel user);
}
