package me.halotu.dao;

import java.util.List;

import me.halotu.mapper.RowMapper;

public interface GenericDAO<T> {
	List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
	int update (String sql, Object... parameters);
	Long insert (String sql, Object... parameters);
}
