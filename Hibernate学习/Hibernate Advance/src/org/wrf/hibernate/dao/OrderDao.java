package org.wrf.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.wrf.hibernate.pojos.Order;
import org.wrf.hibernate.utils.HibernateUtils;

public class OrderDao {
	/*添加order对象*/
	public static void addOrder(Order order) {
		//获取Session对象
		Session session=HibernateUtils.getSession();
		//开启事务
		Transaction trans=session.beginTransaction();
		//保存对象
		session.save(order);
		//提交事务
		trans.commit();
		//关闭Session
		HibernateUtils.closeSession();
	}
}
