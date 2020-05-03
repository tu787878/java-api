package me.halotu.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import me.halotu.model.UserModel;

public class UserMapper implements RowMapper<UserModel> {

	public UserModel mapRow(ResultSet resultSet) {
		try {
			UserModel user = new UserModel();
			user.setId(resultSet.getLong("id"));
			user.setUsername(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			return user;
		} catch (SQLException e) {
			return null;
		}	
	}
}
