package com.netbank.biz;

import com.netbank.entity.Account;
import com.netbank.entity.Admin;
import com.netbank.entity.Personinfo;

public interface UserBiz {
	//根据账户名称获取账户
	public Account getAccount(String username);
	//修改账户
	public abstract boolean modifyAccount(Account account);
	//刷新账户
	public void refresh(Account account);
	//根据账户id获取账户
	public abstract Account getAccount(int accountid);
	//根据username获取管理员
	public abstract Admin getAdmin(String username);
	//启用账户
	public void enabled(int id);
	//冻结账户
	public void locking(int id);
	//删除账户
	public boolean delAccount(int id);
	//添加账户
	public boolean addAccount(Account account);
}
