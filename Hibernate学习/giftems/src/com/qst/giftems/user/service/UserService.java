package com.qst.giftems.user.service;

import com.qst.giftems.user.daos.UserDao;
import com.qst.giftems.user.pojos.User;

public class UserService {
    /**UserDao**/
	private UserDao userDao = new UserDao();
	/**
	 * 根据用户名或手机号查询用户对象
	 * @param name
	 * @return
	 */
	public User findUserByNameOrMobile(String name) {
		return userDao.findUserByNameMobile(name);
	}
	/**
	 * 根据用户名查找用户对象
	 * @param userName
	 * @return
	 */
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}
	/**
	 * 注册用户
	 */
	public void doRegister(User user) {
		userDao.save(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
