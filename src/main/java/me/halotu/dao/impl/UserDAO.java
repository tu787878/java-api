package me.halotu.dao.impl;

import java.util.List;

import me.halotu.dao.IUserDAO;
import me.halotu.mapper.UserMapper;
import me.halotu.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	public UserModel findOne(Long id) {
		String sql = "SELECT * FROM user WHERE id = ?";
		List<UserModel> user = query(sql, new UserMapper(), id);
		return user.isEmpty() ? null : user.get(0);
	}

	public UserModel addUser(UserModel user) {
		StringBuilder sql = new StringBuilder("INSERT INTO user (username, password)");
		sql.append(" VALUES (?, ?)");
		Long id = insert(sql.toString(), user.getUsername(), user.getPassword());
		if(id!=null) {
			String sql2 = "SELECT * FROM user WHERE id = ?";
			List<UserModel> user2 = query(sql2, new UserMapper(), id);
			return user2.isEmpty() ? null : user2.get(0);
		}else {
			return null;
		}
	}

	@Override
	public List<UserModel> getUsers() {
		StringBuilder sql = new StringBuilder("SELECT * FROM user");
		return query(sql.toString(), new UserMapper());
	}

	@Override
	public UserModel update(UserModel user) {
		StringBuilder sql = new StringBuilder("UPDATE user SET username = ?, password = ? WHERE id = ?");
		int status = update(sql.toString(), user.getUsername(), user.getPassword(), user.getId());

		if (status != 0) {
			String sql2 = "SELECT * FROM user WHERE id = ?";
			List<UserModel> user2 = query(sql2, new UserMapper(), user.getId());
			return user2.isEmpty() ? null : user2.get(0);
		} else {
			return null;
		}
	}

}
