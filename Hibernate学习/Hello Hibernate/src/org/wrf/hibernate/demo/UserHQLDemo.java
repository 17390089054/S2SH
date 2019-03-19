package org.wrf.hibernate.demo;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.wrf.hibernate.pojos.User;

public class UserHQLDemo {
	public static void main(String[] args) {
		//创建Configuration对象
		Configuration configuration=new Configuration();
		//加载hibernate.cfg.xml
		configuration.configure("/hibernate.cfg.xml");
		//创建SessionFactory对象(Hibernate4.3)
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());
		SessionFactory sessionFactory=configuration.buildSessionFactory(builder.build());
		//打开Session
		Session session=sessionFactory.openSession();
		//开启一个事务
		Transaction transaction=session.beginTransaction();
		
		
		//查询tbUser表
		Query query=session.createQuery("from User");
		//执行查询
		List<User>list=query.list();
		//遍历输出
		for(User u:list) {
			System.out.println(u);
		}
		
		
		//提交事务
		transaction.commit();
		//关闭Session
		session.close();
			
	}

}
