package org.wrf.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.wrf.hibernate.pojos.Customer;
import org.wrf.hibernate.utils.HibernateUtils;


public class CustomerDao {
	/*添加客户*/
	public static void addCustomer(Customer customer) {
		//获取Session对象
		Session session=HibernateUtils.getSession();
		//开启事务
		Transaction trans=session.beginTransaction();
		//持久化操作
		session.save(customer);
		//提交事务
		trans.commit();
		//关闭session
		HibernateUtils.closeSession();
	}
	
	/*获取客户*/
	public static Customer getCustomer(String id) {
		//获取Session对象
		Session session=HibernateUtils.getSession();
		//根据id获取Customer对象
		Customer customer=(Customer) session.get(Customer.class, id);
		return customer;
	}
	
	

}
