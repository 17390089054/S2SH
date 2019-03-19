package com.news.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import com.news.dao.AdminDao;
import com.news.entity.Admin;


public class AdminDaoImpl implements AdminDao {
	
	private SessionFactory sesssionFactory;
	public void setSesssionFactory(SessionFactory sesssionFactory) {
		this.sesssionFactory = sesssionFactory;
	}
	
	@Override
	public List<?> search(Admin condition) {
		List<Admin>list=null;
		//通过sessionFactory获得Session
		Session session=sesssionFactory.getCurrentSession();
		//创建Criteria对象
		Criteria c= session.createCriteria(Admin.class);
		//使用Example工具类创建示例对象
		Example example=Example.create(condition);
		//为Criteria对象指定示例对象example作为查询条件
		c.add(example);
		list=c.list(); //执行查询，获取结果
		return list;
	}

}
