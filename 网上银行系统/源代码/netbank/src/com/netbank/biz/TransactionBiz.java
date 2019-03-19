package com.netbank.biz;

import java.util.List;

import com.netbank.entity.Account;
import com.netbank.entity.Pager;
import com.netbank.entity.TransactionLog;

public interface TransactionBiz {
	//存款
	public boolean deposit(TransactionLog log);
	//取款
	public boolean withdrawal(TransactionLog log);
	//转账
	public boolean transfer(TransactionLog log);
	//获取交易记录
	public List<TransactionLog> getLogs(Account account,int page);
	//获得账户的交易记录总数，用来初始化分页类pager对象并设置其perPageRows和rowCount属性
	public Pager getPagerOfLogs(Account account);
	
	
}
