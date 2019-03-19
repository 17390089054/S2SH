package org.wrf.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.wrf.hibernate.pojos.User;

public class UserDemo {
	public static void main(String[] args) {
		//1 创建User对象
		User user=new User("王五","123",1);
		//2 创建Configuration对象
		Configuration configuration=new Configuration();
		//3 加载hibernate.cfg.xml
		configuration.configure("/hibernate.cfg.xml");
		//4 创建SessionFactory对象(Hibernate4.3)
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());
		SessionFactory sessionFactory=configuration.buildSessionFactory(builder.build());
		//5 打开Session
		Session session=sessionFactory.openSession();
		//6 开启一个事务
		Transaction transaction=session.beginTransaction();
		//7 持久化操作 （插入User对象）
		session.save(user);
		//8 提交事务
		transaction.commit();
		//9 关闭Session
		session.close();
	
	}

}
