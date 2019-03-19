package com.netbank.biz.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.netbank.biz.PersoninfoBiz;
import com.netbank.dao.PersoninfoDao;
import com.netbank.dao.UserDao;
import com.netbank.entity.Personinfo;
import com.netbank.entity.Status;

//使用@Transactional注解实现事务管理
@Transactional
public class PersoninfoBizImpl implements PersoninfoBiz {
	//使用PersoninfoDao接口定义对象，并添加set方法，用于依赖注入
	private PersoninfoDao personinfoDao ;
	public void setPersoninfoDao(PersoninfoDao personinfoDao) {
		this.personinfoDao = personinfoDao;
	}
	//使用UserDao接口定义对象，并添加set方法，用于依赖注入
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public boolean modifyPersoninfo(Personinfo personinfo) {
		personinfoDao.modifyPersoninfo(personinfo);
		return true;
	}
	
	/**
	 * 根据账户状态获取个人信息，状态为0表示获取所有客户
	 */
	@Override
	public List<Personinfo> searchPersoninfo(Status status) {
		List<Personinfo> users=new ArrayList<Personinfo>();
		if(status.getId()!=0){
			//如果账户状态编号不为0，则根据编号获取相应的客户记录
			status=userDao.getStatus(status.getId());
			users=personinfoDao.searchPersoninfo(status);
		}else{
			//如果账户状态编号等于0，则获取所有客户的记录
			users=personinfoDao.getAllPersoninfo();
		}
		return users;
	}
	/**
	 * 根据条件获取个人信息
	 */
	@Override
	public List<Personinfo> searchPersoninfo(Personinfo personinfo) {
		return personinfoDao.searchPersoninfo(personinfo);
	}
	/**
	 * 添加个人信息
	 */
	@Override
	public boolean add(Personinfo personinfo) {
		return personinfoDao.add(personinfo);
	}

}
