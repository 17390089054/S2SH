package com.netbank.biz.impl;

import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.netbank.biz.TransactionBiz;
import com.netbank.dao.TransactionDao;
import com.netbank.dao.UserDao;
import com.netbank.entity.Account;
import com.netbank.entity.Pager;
import com.netbank.entity.TransactionLog;
import com.netbank.entity.TransactionType;


//使用@Transactional注解实现事务管理
@Transactional
public class TransactionBizImpl implements TransactionBiz {
	//使用TransactionDao接口声明属性，并添加set方法用于依赖注入
	private TransactionDao transactionDao;
	public void setTransactionDao(TransactionDao transactionDao) {
		this.transactionDao = transactionDao;
	}
	
	//使用UserDao接口声明属性，并添加set方法用于依赖注入
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 存款
	 */
	@Override
	public boolean deposit(TransactionLog log) {
		//从交易对象Log中取出账户对象
		Account self=log.getAccount();
		//将账户余额与存款金额相加
		self.setBalance(log.getAccount().getBalance()+log.getTrMoney());
		//更新账户表Account，修改账户余额
		userDao.updateAccount(self);
		//根据交易类型获取交易类型对象
		TransactionType type=transactionDao.getTransactionType("存款");
		log.setTransactionType(type);
		log.setOtherid(self.getAccountid());
		//向数据表transaction_log中添加交易记录
		return transactionDao.addLog(log);
	}

	/**
	 * 取款
	 */
	@Override
	public boolean withdrawal(TransactionLog log) {
		//从交易信息对象中取出账户对象
		Account self=log.getAccount();
		//将账户余额与取款金额相减
		self.setBalance(log.getAccount().getBalance()-log.getTrMoney());
		//更新账户表Account，修改账户余额
		userDao.updateAccount(self);
		//根据交易类型获取交易类型对象
		TransactionType type=transactionDao.getTransactionType("取款");
		log.setTransactionType(type);
		log.setOtherid(self.getAccountid());
		//向数据表transaction_log中添加交易记录
		return transactionDao.addLog(log);
	}

	/**
	 * 
	 * 转账
	 */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED)
	@Override
	public boolean transfer(TransactionLog log) {
		//获取入账方账户对象
		Account other=userDao.getAccount(log.getOtherid());
		//获取转账方账户对象
		Account self=log.getAccount();
		if(other!=null){
			//修改转账方账户余额
			self.setBalance(log.getAccount().getBalance()-log.getTrMoney());
			//修改入账方账户余额
			other.setBalance(other.getBalance()+log.getTrMoney());
			//将转账方账户余额更新到数据表Account
			userDao.updateAccount(self);
			//将入账方账户余额更新到数据表Account
			userDao.updateAccount(other);
			//根据交易类型获取交易类型对象
			TransactionType type=transactionDao.getTransactionType("转账");
			log.setTransactionType(type);
			//向数据表transaction_log中添加交易记录
			return transactionDao.addLog(log);
		}
		return false;
	}

	/**
	 * 获取交易记录
	 */
	@Override
	public List<TransactionLog> getLogs(Account account, int page) {
		return transactionDao.getLogs(account, page);
	}

	/**
	 * 获取交易记录总数，用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
	 */
	@Override
	public Pager getPagerOfLogs(Account account) {
		//从数据表Transaction_Log中获取与账户相关的记录总数
		int count=transactionDao.getCountOfLogs(account);
		//使用分页类Pager定义对象
		Pager pager=new Pager();
		//设置pager对象中的perPageRows属性，表示每页显示的记录数
		pager.setPerPageRows(3);
		//设置pager对象中的rowCount属性，表示记录总数
		pager.setRowCount(count);
		pager.setPageCount();
		//返回pager对象
		return pager;
	}

}
