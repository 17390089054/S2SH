package org.wrf.hibernate.demo;

import java.util.Date;
import java.util.Set;
import org.wrf.hibernate.dao.CustomerDao;
import org.wrf.hibernate.dao.OrderDao;
import org.wrf.hibernate.pojos.Customer;
import org.wrf.hibernate.pojos.Order;

public class OrderCustomerDemo {
	public static void main(String[] args) {
		//addOrderCustomer();
		//getCustomer();
		addCustomerWithCascade();
	
	}

	/*级联保存*/
	private static void addCustomerWithCascade() {
		//实例化一个客户信息对象
		Customer customer=new Customer("李四","123456","长春市");
		//实例化一个订单信息对象
		Order order=new Order("5",new Date(),customer);
		//建立关联关系，实现级联保存
		customer.getOrders().add(order);
		System.out.println("----级联保存客户和订单----");
		//调用客户数据访问类CustomerDao中的addCustomer()方法将customer对象数据保存到数据库中
		CustomerDao.addCustomer(customer);
		
	}

	/*获取客户信息*/
	private static void getCustomer() {
		//根据id获取Customer对象
		Customer customer=CustomerDao.getCustomer("40280981691957ff0169195802070000");
		//获取Order集合
		Set<Order>orders=customer.getOrders();
		//打印相关信息
		System.out.println("客户:"+customer.getUserName()+"的订单如下");
		for(Order order:orders) {
			System.out.print("ID："+order.getId()+",");
			System.out.print("订单编号："+order.getOrderNo()+",");
			System.out.print("下单日期："+order.getDate());
			System.out.println();
		}
		
	}

	/*添加客户和订单*/
	private static void addOrderCustomer() {
		System.out.println("-----添加1条Customer记录----");
		//实例化一个客户信息对象
		Customer customer=new Customer("wangwu","123456","北京市");
		//调用CustomerDao中的addCustomer()方法 将customer对象数据保存到数据库中
		CustomerDao.addCustomer(customer);
		
		System.out.println("----添加2条Order记录----");
		//创建两个Order对象
		Order order1=new Order("1",new Date(),customer);
		Order order2=new Order("2",new Date(),customer);
		
		//调用OrderDao中的addOrder()方法 将两个order对象存入数据库
		OrderDao.addOrder(order1);
		OrderDao.addOrder(order2);
		
	}
	
	
	
	
	
	
}
