package com.netbank.dao;

import java.util.List;

import com.netbank.entity.Account;
import com.netbank.entity.TransactionLog;
import com.netbank.entity.TransactionType;

public interface TransactionDao {
	//根据交易类型名称获取交易类型对象
	public TransactionType getTransactionType(String name);
	//向数据表transaction_log中添加交易记录
	public boolean addLog(TransactionLog log);
	//根据待显示页码和账户对象获取交易记录
	public List<TransactionLog>getLogs(Account account,int page);
	//获取交易记录数
	public Integer getCountOfLogs(Account account);
	
}
