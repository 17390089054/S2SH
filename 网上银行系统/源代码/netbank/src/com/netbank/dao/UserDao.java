package com.netbank.dao;

import com.netbank.entity.Account;
import com.netbank.entity.Admin;
import com.netbank.entity.Status;

public interface UserDao{
	//根据客户名获取账户对象
	public Account getAccount(String username);
	//修改账户
	public boolean updateAccount(Account account);
	//刷新账户
	public void refreshAccount(Account account);
	//根据账户id获取账户对象
	public Account getAccount(int accountid);
	//根据username获取管理员
	public Admin getAdmin(String username);
	//根据编号获取状态
	public Status getStatus(Integer id);
	//根据账户状态名称获取账户对象
	public Status getStatus(String name);
	//删除账户
	public boolean  delAccount(Account account);
	//添加账户
	public boolean addAccount(Account account);
	
}
