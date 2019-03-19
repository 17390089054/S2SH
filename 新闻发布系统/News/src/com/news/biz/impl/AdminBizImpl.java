package com.news.biz.impl;

import java.util.List;

import com.news.biz.AdminBiz;
import com.news.dao.AdminDao;
import com.news.entity.Admin;

public class AdminBizImpl implements AdminBiz {
	//使用AdminDao接口声明属性adminDao，并添加set方法，用于依赖注入
	private AdminDao adminDao;
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	@Override
	public List<?> Login(Admin condition) {
		return adminDao.search(condition);
	}

}
