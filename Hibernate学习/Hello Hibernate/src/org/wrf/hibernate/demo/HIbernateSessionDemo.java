package org.wrf.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.wrf.hibernate.pojos.User;
import org.wrf.hibernate.utils.HibernateUtils;

public class HIbernateSessionDemo {
	public static void main(String[] args) {
		//调用getUser()方法获取用户对象
		User user=getUser(new Integer(26));
		System.out.println("====原始数据====");
		System.out.println(user);
		user.setUserPwd("123456");
		//调用changeUser()方法修改用户信息
		changeUser(user);
		System.out.println("====修改后的数据====");
		System.out.println(user);
		
	}
	/*修改用户信息*/
	private static void changeUser(User user) {
		Session session=HibernateUtils.getSession();
		//开启事务
		Transaction tran=session.beginTransaction();
		//更新
		session.update(user);
		//提交事务
		tran.commit();
		//关闭session
		HibernateUtils.closeSession();
		
	}

	/*获取用户*/
	private static User getUser(Integer key) {
		Session session=HibernateUtils.getSession();
		Transaction transaction=session.beginTransaction();
		//根据主键获取用户对象
		User user=(User) session.get(User.class, key);
		transaction.commit();
		HibernateUtils.closeSession();
		return user;
	}
}
