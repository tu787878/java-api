package me.halotu.service.impl;

import java.util.List;

import me.halotu.dao.impl.DBConnection;
import me.halotu.dao.impl.UserDAO;
import me.halotu.model.UserModel;
import me.halotu.service.IUserService;

public class UserService implements IUserService{
	UserDAO userDao = new UserDAO();
		
	public void testConnection() {
		DBConnection.initializeDatabase();
	}

	public UserModel findOne(Long id) {
		UserModel user = userDao.findOne(id);
		return user;
	}

	public UserModel addUser(UserModel user) {
		UserModel user2 = userDao.addUser(user);
		return user2;
	}

	@Override
	public List<UserModel> getUsers() {
		List<UserModel> users = userDao.getUsers();
		return users;
	}

	@Override
	public UserModel update(UserModel userToUpdate) {
		UserModel user = userDao.update(userToUpdate);
		return user;
	}



}
