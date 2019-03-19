package com.netbank.biz.impl;

import org.springframework.transaction.annotation.Transactional;
import com.netbank.biz.UserBiz;
import com.netbank.dao.UserDao;
import com.netbank.entity.Account;
import com.netbank.entity.Admin;
import com.netbank.entity.Status;

//使用@Transactional注解实现事务管理
@Transactional
public class UserBizImpl implements UserBiz {
	//使用UserDao接口声明对象，并添加set方法，用于依赖注入
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//根据username获取账户
	@Override
	public Account getAccount(String username) {
		return userDao.getAccount(username);
	}

	//修改账户
	@Override
	public boolean modifyAccount(Account account) {
		return userDao.updateAccount(account);
	}

	//刷新账户
	@Override
	public void refresh(Account account) {
		userDao.refreshAccount(account);
	}
	
	//根据账户ID获取账户
	@Transactional(readOnly=true)
	@Override
	public Account getAccount(int accountid) {
		return userDao.getAccount(accountid);
	}
	
	//根据username获取管理员
	@Override
	public Admin getAdmin(String username) {
		return userDao.getAdmin(username);
	}

	/**
	 * 启用账户
	 */
	@Override
	public void enabled(int id) {
		//根据账户编号获取账户对象
		Account account=userDao.getAccount(id);
		//修改账户对象的状态属性，设置为启用
		Status status=userDao.getStatus("正常");
		account.setStatus(status);
		//更新账户
		userDao.updateAccount(account);
	}

	/**
	 * 冻结账户
	 * @param id
	 */
	@Override
	public void locking(int id) {
		//根据账户编号获取账户对象
		Account account=userDao.getAccount(id);
		//修改账户对象的状态属性，设置为启用
		Status status=userDao.getStatus("冻结");
		account.setStatus(status);
		//更新账户
		userDao.updateAccount(account);
	}
	
	/**
	 * 删除账户
	 * @param id
	 * @return
	 */
	@Override
	public boolean delAccount(int id) {
		//根据账户id获取账户
		Account account=userDao.getAccount(id);
		//删除账户对象，同时执行级联删除
		return userDao.delAccount(account);
	}

	/**
	 * 添加账户
	 */
	@Override
	public boolean addAccount(Account account) {
		Status status = userDao.getStatus("正常");
		account.setStatus(status);
		return userDao.addAccount(account);
	}

	

}
