package org.wrf.hibernate.pojos;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Customer implements Serializable{
	// @Fields serialVersionUID : TODO
	private static final long serialVersionUID = 1L;
	private String id;//定义ID属性
	private String userName;//定义用户名
	private String pwd;//定义密码
	private String address;//定义客户地址
	/*订单集合orders*/
	private Set<Order> orders = new HashSet<Order>(0);
	/*增加身份证对象*/
	private IdCard idCard;


	//默认构造方法
	public Customer() {
		super();
	}
	//带参数的构造方法
	public Customer(String userName, String pwd, String address) {
		this.userName = userName;
		this.pwd = pwd;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public IdCard getIdCard() {
		return idCard;
	}
	public void setIdCard(IdCard idCard) {
		this.idCard = idCard;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", userName=" + userName + ", pwd=" + pwd + ", address=" + address + ", orders="
				+ orders + ", idCard=" + idCard + "]";
	}
	

}

