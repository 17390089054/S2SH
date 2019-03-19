package com.news.dao;

import java.util.List;

import com.news.entity.Admin;

public interface AdminDao {
	public List<?> search(Admin condition);
}
