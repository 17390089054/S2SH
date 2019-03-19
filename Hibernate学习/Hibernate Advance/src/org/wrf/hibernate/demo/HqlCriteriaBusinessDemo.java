package org.wrf.hibernate.demo;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.wrf.hibernate.pojos.Customer;
import org.wrf.hibernate.pojos.Product;
import org.wrf.hibernate.utils.HibernateUtils;

public class HqlCriteriaBusinessDemo {
	public static void main(String[] args) {
		//findCustomerByAddress_HQL("长春市");
		//findCustomerByAddress_QBC("青岛市");
		//orderByUserNameDesc_HQL();
		//orderByUserNameDesc_QBC();
		// findOneCustomer_HQL();
		//findOneCustomer_QBC();
		//第2页，每页3条记录
		/*List<Customer> list = findCustomerByName("wangwu");
		for(Customer c:list) {
			System.out.println(c);
		}*/
		//printOrders_QBC();
		//groupByCustomer();
		//findCustomerByLeftFetch();
		/*List<Product>listProduct=findProductsByQBC("打印机",560.0);*/
		/*Product product=new Product();
		product.setName("打印机");
		product.setPrice(560.0);*/
		/*List<Product>listProduct=findProductsByQBE(product);
		for(Product p:listProduct) {
			System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getPrice()+"\t"+p.getDescription());
		}*/
		//findProductsBySubQuerys();
		
	}
	//批量更新数据
	private void updateBatch() {
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		/*查询出Customer表中的所有对象*/
		ScrollableResults customers=session.createQuery("from Customer").scroll();
		int count=0;
		//遍历所有Customer对象
		while(customers.next()) {
			Customer customer=(Customer) customers.get(0);
			customer.setUserName("username"+count);
			//每保存10个Customer对象，清空一次缓存
			if(count%10==0) {
				session.flush();
				session.clear();
				trans.commit();
				trans=session.beginTransaction();
			}
			count++;
		}
		//提交事务
		trans.commit();
		//关闭Session对象
		HibernateUtils.closeSession();
		
	}
	
	private static void updateBatch2() {
		Session session=HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		//定义HQL语句
		String hql="update Customer set name=:name";
		//获取Query对象
		Query query=session.createQuery(hql);
		//进行参数绑定
		query.setString("name", "wrf");
		//执行更新
		query.executeUpdate();
		//提交事务
		trans.commit();
		//关闭Session对象
		HibernateUtils.closeSession();
	}
	
	private static void updateBatch3() {
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		//定义hql语句
		String hql="update Customer set name=:name";
		//返回更新的数量
		int count=session.createQuery(hql).setString("name", "wrf").executeUpdate();
		//提交事务
		trans.commit();
		//关闭Session对象
		HibernateUtils.closeSession();
	}
	
	//批量删除
	private static void deleteBatch() {
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		//定义HQL删除语句
		String hql="delete Customer";
		//返回删除的数量
		int count=session.createQuery(hql).executeUpdate();
		//提交事务
		trans.commit();
		//关闭session
		HibernateUtils.closeSession();
		
	}
	
	
	//批量插入数据
	private static void addBatch() {
		//获取Session对象
		Session session=HibernateUtils.getSession();
		//开启事务
		Transaction trans=session.beginTransaction();
		try {
			/*保存1000000个Customer对象*/
			for(int i=0;i<10;i++) {
				Customer customer=new Customer();
				customer.setUserName("test"+i);
				//保存对象
				session.save(customer);
				//每保存10个Customer对象，清空一次缓存
				if(i%5==0) {
					//刷新缓存
					session.flush();
					//清空缓存
					session.clear();
					//提交事务
					trans.commit();
					//重新开始事务
					trans=session.beginTransaction();
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			//出现异常则回滚
			trans.rollback();
		}
		//提交事务
		trans.commit();
		//关闭Session对象
		HibernateUtils.closeSession();
		
	}

	//单行子查询
	public static void findProductsBySubQuerys() {
		Session session=HibernateUtils.getSession();
		String hql="from Product p where p.price=(select p1.price from Product p1 where p1.name= :name) and p.name!=:name";
		Query query=session.createQuery(hql);
		query.setString("name", "打印机");
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		for(Product p:list) {
			System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getPrice()+"\t"+p.getDescription());
		}
	}
	
	
	
	//QBE动态查询商品信息
	@SuppressWarnings("unchecked")
	public static List<Product>findProductsByQBE(Product product){
		Session session=HibernateUtils.getSession();
		/*customer为样本对象，根据查询条件创建的对象*/
		Example example=Example.create(product)
				.enableLike(MatchMode.ANYWHERE)
				.excludeNone()
				.excludeZeroes()
				.ignoreCase();
		Criteria criteria=session.createCriteria(Product.class);
		criteria.add(example);
		return criteria.list();
	}
	
	//添加产品信息
	@Test
	public void addCustomer() {
		Product product=new Product("微波炉",560.0,"美的家电");
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		session.save(product);
		trans.commit();
		session.close();
	}
	
	//QBC动态查询产品信息
	private static List<Product> findProductsByQBC(String name, double price) {
		Session session=HibernateUtils.getSession();
		Criteria criteria=session.createCriteria(Product.class);
		if(name!=null) {
			criteria.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
		}
		if(price!=0) {
			criteria.add(Restrictions.eq("price", price));
		}
		return criteria.list();
	}
	
	
	/*HQL动态查询产品信息*/
	@SuppressWarnings("unchecked")
	private static List<Product> findProductsByHQL(String name, double price) {
		Session session = HibernateUtils.getSession();
		StringBuffer buffer = new StringBuffer();
		// 生成基础SQL
		buffer.append("from Product p where 1=1");
		// 如果name满足条件，则加入语句中
		if (name != null) {
			buffer.append(" and lower(p.name) like :name");
		}
		// 如果age满足条件，则加入语句中
		if (price != 0) {
			buffer.append(" and p.price = :price");
		}
		Query query = session.createQuery(buffer.toString());
		if (name != null) {
			query.setString("name", "%" + name.toLowerCase() + "%");
		}
		if (price != 0) {
			query.setDouble("price", price);
		}
		return query.list();
	}

	//按照 客户ID分组，统计每个顾客的订单数目
	public static void groupByCustomer() {
		Session session = HibernateUtils.getSession();
		String hql = "select c.userName,count(o) from Customer c left join c.orders o group by c.id,c.userName";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.list();
		for (Object[] objs : list) {
			String username = (String) objs[0];
			Long count = (Long) objs[1];
			System.out.println("用户名: " + username + "  订单数：" + count);
		}
	}
	
	
	
	
	/*HQL预先抓取左外连接*/
	public static void findCustomerByLeftFetch() {
		//如果程序代码中使用left outer join on接则覆盖配置文件中的所有检索策略
		Session session = HibernateUtils.getSession();
		//使用HQL进行内连接
		String hql="from Customer c left join fetch c.orders  where c.address=?";
		Query query = session.createQuery(hql);
		query.setString(0, "青岛市");
		@SuppressWarnings("unchecked")
		List<Customer>list=query.list();
		//使用HashSet过滤重复的元素
		Set<Customer>set=new HashSet<Customer>(list);
		for(Customer customer:set) {
			System.out.print(customer.getId()+" * "+customer.getUserName()+" * ");
			for(org.wrf.hibernate.pojos.Order order:customer.getOrders()) {
				System.out.print(order.getOrderNo()+" ");
			}
			System.out.println();
		}
	}
	
	
	
	
	//左外连接
	public static void findCustomerByLeftJoin() {
		Session session = HibernateUtils.getSession();
		//使用HQL进行内连接
		String hql="from Customer c left outer join c.orders o where c.address =?";
		Query query = session.createQuery(hql);
		query.setString(0, "青岛市");
		@SuppressWarnings("unchecked")
		List<Object[]>list=query.list();
		for(Object[]objs:list) {
			Customer customer=(Customer)objs[0];
			System.out.print(customer.getId()+" "+customer.getUserName()+" ");
			org.wrf.hibernate.pojos.Order order=(org.wrf.hibernate.pojos.Order)objs[1];
			if(order!=null) {
				System.out.println(order.getOrderNo());
			}
			System.out.println();
		}
	}
	
	
	
	
	/*HQL预先抓取内连接*/
	public static void findCustomerByFetchJoin() {
		Session session = HibernateUtils.getSession();
		//使用HQL进行内连接
		String hql="from Customer c inner join fetch c.orders o where c.userName like :name";
		Query query = session.createQuery(hql);
		query.setString("name", "z%");
		@SuppressWarnings("unchecked")
		List<Customer>list=query.list();
		//使用HashSet过滤重复的元素
		Set<Customer>set=new HashSet<Customer>(list);
		for(Customer customer:set) {
			System.out.print(customer.getId()+" * "+customer.getUserName()+" * ");
			for(org.wrf.hibernate.pojos.Order order:customer.getOrders()) {
				System.out.print(order.getOrderNo()+" ");
			}
			System.out.println();
		}
	}
	
	
	/*HQL内连接*/
	public static void findCustomerByJoin() {
		Session session = HibernateUtils.getSession();
		//使用HQL进行内连接
		String hql="from Customer c inner join c.orders o where c.userName like :name";
		Query query = session.createQuery(hql);
		query.setString("name", "z%");
		@SuppressWarnings("unchecked")
		List<Object[]>list=query.list();
		for(Object[]objs:list) {
			Customer customer=(Customer)objs[0];
			System.out.print(customer.getId()+" * "+customer.getUserName()+" * ");
			org.wrf.hibernate.pojos.Order order=(org.wrf.hibernate.pojos.Order)objs[1];
			System.out.print(order.getOrderNo()+" * ");
			System.out.print(order.getDate());
			System.out.println();
		}
	}
	
	
	
	
	
	/*QBC检索2月份的订单对象*/
	public static void printOrders_QBC() {
		Session session = HibernateUtils.getSession();
		//HQL检索日期在指定范围之内
		String hql="from Order o where o.date between ? and ?";
		//创建一个日期格式类 用于格式化日期
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			//QBC检索
			List<org.wrf.hibernate.pojos.Order>list=session.createCriteria(org.wrf.hibernate.pojos.Order.class)
			.add(Restrictions.between("date",
					sf.parse("2019-02-23 19:30:00"),
					sf.parse("2019-02-23 20:00:00")
					)
					).list();

			//打印结果
			for(org.wrf.hibernate.pojos.Order o:list) {
				System.out.println(o.getId()+"\t"+o.getDate());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	/*HQL检索3月份的订单对象*/
	public static void printOrders_HQL() {
		Session session = HibernateUtils.getSession();
		//HQL检索日期在指定范围之内
		String hql="from Order o where o.date between ? and ?";
		//创建一个日期格式类 用于格式化日期
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			List<org.wrf.hibernate.pojos.Order>list=session.createQuery(hql)
					.setParameter(0, sf.parse("2019-02-23 19:00:00"))
					.setParameter(1, sf.parse("2019-02-23 19:30:00"))
					.list();
			//打印结果
			for(org.wrf.hibernate.pojos.Order o:list) {
				System.out.println(o.getId()+"\t"+o.getDate());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public static List<Customer> findCustomerByName1(String name){
		//获取session对象
		Session session = HibernateUtils.getSession();
		//创建查询HQL语句，根据realName查询符合条件的对象
		String hql="from Customer c where c.userName=:name";
		//执行查询
		Query query = session.createQuery(hql);
		//按照参数名进行绑定
		query.setString("name", name);
		//获取查询结果
		return query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public static List<Customer> findCustomerByName2(String name){
		//获取session对象
		Session session = HibernateUtils.getSession();
		//创建查询HQL语句，根据realName查询符合条件的对象
		String hql="from Customer c where c.userName=?";
		//执行查询
		Query query = session.createQuery(hql);
		//按照参数位置进行绑定
		query.setString(0,name);
		//获取查询结果
		return query.list();
	}
	
	
	//通过参数查询Customer信息
	public static List<Customer> findCustomerByName(String name){
		//获取session对象
		Session session = HibernateUtils.getSession();
		//创建查询HQL语句，根据realName查询符合条件的对象
		String hql="from Customer c where c.userName='"+name+"'";
		//执行查询
		Query query = session.createQuery(hql);
		//获取查询结果
		@SuppressWarnings("unchecked")
		List<Customer> list = query.list();
		
		
		return list;
	}
	
	/*使用QBC分页查询Customer信息*/
	public static List<Customer>listPageCustomer_QBC(int pageNo,int pageNum){
		Session session = HibernateUtils.getSession();
		Criteria criteria = session.createCriteria(Customer.class);
		//设置起始页和页面记录数
		criteria.setFirstResult((pageNo-1)*pageNum);
		criteria.setMaxResults(pageNum);
		//获取查询结果
		@SuppressWarnings("unchecked")
		List<Customer>list=criteria.list();
		return list;
	}
	
	//利用HQL检索单个Customer对象
		public static void findOneCustomer_HQL() {
			Session session = HibernateUtils.getSession();
			String hql="from Customer c order by c.userName desc";
			Customer customer = (Customer)session.createQuery(hql).setMaxResults(1).uniqueResult();
			System.out.println(customer);
		}
		
		//利用QBC检索单个Customer对象
		public static void findOneCustomer_QBC() {
			Session session = HibernateUtils.getSession();
			Customer customer=(Customer)session.createCriteria(Customer.class)
			.addOrder(Order.desc("userName"))
			.setMaxResults(1)
			.uniqueResult();
			System.out.println(customer);
		}
	
	/*使用HQL分页查询Customer信息*/
	public static List<Customer>listPageCustomer_HQL(int pageNo,int pageNum){
		//获取session对象
		Session session = HibernateUtils.getSession();
		//拼写hql
		String hql="from Customer c order by c.userName desc";
		//获取query对象
		Query query = session.createQuery(hql);
		//设置页面起始记录和每页的记录数
		query.setFirstResult((pageNo-1)*pageNum);
		query.setMaxResults(pageNum);
		//执行查询
		@SuppressWarnings("unchecked")
		List<Customer> list = query.list();
		return list;
	}
	
	
	
	
	/*使用QBC对查询结果按照Customer的userName进行降序排列*/
	private static void orderByUserNameDesc_QBC() {
		//获取Session对象
		Session session = HibernateUtils.getSession();
		//获取criteria对象
		Criteria criteria = session.createCriteria(Customer.class);
		//添加排序规则
		criteria.addOrder(Order.desc("userName"));
		//查询结果
		@SuppressWarnings("unchecked")
		List<Customer> list = criteria.list();
		//遍历结果
		for(Customer c:list) {
			System.out.println(c);
		}
	}
	

	/*使用HQL对查询结果按照Customer的userName进行降序排列*/
	private static void orderByUserNameDesc_HQL() {
		//获取Session对象
		Session session = HibernateUtils.getSession();
		//编写HQL语句
		String hql="from Customer c order by c.userName desc";
		//创建query对象
		Query query = session.createQuery(hql);
		//调用list()方法获取查询结果
		@SuppressWarnings("unchecked")
		List<Customer> list = query.list();
		//遍历列表
		for(Customer c:list) {
			System.out.println(c);
		}
		
	}

	//使用QBC检索根据地址查询Customer
	private static void findCustomerByAddress_QBC(String address) {
		//获取Session对象
		Session session = HibernateUtils.getSession();
		//以Customer的Class对象作为参数 创建Criteria对象
		Criteria criteria = session.createCriteria(Customer.class);
		//调用Criteria对象的add()方法 增加Criterion查询条件
		criteria.add(Restrictions.eq("address", address));
		//调用criteria的list()方法返回执行结果
		@SuppressWarnings("unchecked")
		List<Customer> list = criteria.list();
		//遍历输出结果
		for(Customer c:list) {
			System.out.println(c);
		}
	}
	
	//使用HQL检索根据地址查询Customer
	private static void findCustomerByAddress_HQL(String address) {
		//获取Session对象
		Session session = HibernateUtils.getSession();
		//编写hql语句
		String hql="from Customer c where c.address=:address";
		//以HQL为参数，调用session的createQuery()方法创建Query对象
		Query query = session.createQuery(hql);
		//调用Query对象的setXXX()方法为参数赋值
		query.setString("address", address);
		//调用query对象的list()等方法得到查询结果
		@SuppressWarnings("unchecked")
		List<Customer> list = query.list();
		//遍历输出结果
		for(Customer c:list) {
			System.out.println(c);
		}
		
	}
	
	

}
