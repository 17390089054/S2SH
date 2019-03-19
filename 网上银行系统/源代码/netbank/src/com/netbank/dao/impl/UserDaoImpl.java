package com.netbank.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.netbank.dao.UserDao;
import com.netbank.entity.Account;
import com.netbank.entity.Admin;
import com.netbank.entity.Status;

public class UserDaoImpl implements UserDao {
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//根据username获取账户
	@Override
	public Account getAccount(String username) {
		Session session=sessionFactory.getCurrentSession();
		String hqlString="from Account where username='"+username+"'";
		Query query = session.createQuery(hqlString);
		return (Account) query.uniqueResult();
	}

	//修改账户
	@Override
	public boolean updateAccount(Account account) {
		Session session=sessionFactory.getCurrentSession();
		session.merge(account);
		return true;
	}
	
	//刷新账户
	@Override
	public void refreshAccount(Account account) {
		//从session中重新获取对象account
		Session session=sessionFactory.getCurrentSession();
		session.refresh(account);
		
	}

	//根据账户id获取账户对象
	@Override
	public Account getAccount(int accountid) {
		Session session=sessionFactory.getCurrentSession();
		return (Account)session.get(Account.class, accountid);
	}

	//根据username获取管理员
	@Override
	public Admin getAdmin(String username) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Admin as a where a.username='"+username+"'";
		Query query=session.createQuery(hql);
		return (Admin) query.uniqueResult();
	}

	//根据Id获取状态
	@Override
	public Status getStatus(Integer id) {
		Session session=sessionFactory.getCurrentSession();
		Status status = (Status) session.get(Status.class, id);
		return status;
	}

	/**
	 * 根据名称获取状态
	 */
	@Override
	public Status getStatus(String name) {
		Session session=sessionFactory.getCurrentSession();
		String hql="from Status as s where s.name='"+name+"'";
		Query query=session.createQuery(hql);
		return (Status) query.uniqueResult();
	}

	/**
	 * 删除账户
	 */
	@Override
	public boolean delAccount(Account account) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(account);
		return true;
	}
	
	//添加账户
	@Override
	public boolean addAccount(Account account) {
		Session  session=sessionFactory.getCurrentSession();
		session.save(account);
		return true;
	}

}
