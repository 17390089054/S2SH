package com.qst.giftems.user.daos;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qst.core.utils.HibernateUtils;
import com.qst.giftems.user.pojos.User;

public class UserDao {
    /**
     * 根据姓名或电话进行查询
     * @param name
     * @return
     */
	public User findUserByNameMobile(String name) {
		Session session = null;
		try {
			//获取Session对象
			session = HibernateUtils.getSession();
			//创建Query对象，并使用HQL进行查询
			Query query = session
					.createQuery("from User u where u.userName = ? or u.mobile = ?");
			//设置参数
			query.setString(0, name);
			query.setString(1, name);
			//返回唯一User对象
			User user = (User) query.uniqueResult();
			return user;
		} finally {
			//释放Session对象
			HibernateUtils.closeSession();
		}
	}
    /**
     * 根据用户名查找
     * @param userName
     * @return
     */
	public User findUserByUserName(String userName) {
		Session session = null;
		try {
			//获取Session对象
			session = HibernateUtils.getSession();
			//创建Query对象，并使用HQL进行查询
			Query query = session
					.createQuery("from User u where u.userName = ?");
			//设置参数
			query.setString(0, userName);
			//返回唯一User对象
			User user = (User) query.uniqueResult();
			return user;
		} finally {
			//释放Session对象
			HibernateUtils.closeSession();
		}
	}
	/**
	 * 保存用户对象
	 * @param user
	 */
	public void save(User user) {
		Session session = null;
		Transaction trans = null;
		try {
			//获取Session对象
			session = HibernateUtils.getSession();
			//提交事务
			trans = session.beginTransaction();
            session.save(user);
            trans.commit();
		} catch(Exception ex){
			//回滚事务
			trans.rollback();
		}finally {
			//释放Session对象
			HibernateUtils.closeSession();
		}
	}

}
