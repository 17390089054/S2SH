package org.wrf.hibernate.demo;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.wrf.hibernate.pojos.Student;

public class StudentCriteriaDemo {
	public static void main(String[] args) {
		//创建Configuration对象
		Configuration configuration=new Configuration();
		//加载hibernate.cfg.xml
		configuration.configure("/hibernate.cfg.xml");
		//创建SessionFactory对象(Hibernate4.3)
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());
		SessionFactory sessionFactory=configuration.buildSessionFactory(builder.build());
		
		
		//使用getCurrentSession获取Session
		Session session=sessionFactory.getCurrentSession();
		
		//开启一个事务
		Transaction transaction=session.beginTransaction();
		//创建一个Criteria查询对象，查询Student类的所有对象
		Criteria criteria=session.createCriteria(Student.class);
		//执行查询
		List<Student>list=criteria.list();
		//遍历输出
		for(Student u:list) {
			System.out.println(u);
		}
		
		
		//提交事务
		transaction.commit();
		
		//关闭Session 使用getCurrentSession()时必须删除 由程序自动关闭session
		//session.close();
			
	}

}
