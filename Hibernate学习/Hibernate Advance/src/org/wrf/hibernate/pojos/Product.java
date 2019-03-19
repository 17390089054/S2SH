package org.wrf.hibernate.pojos;

import java.util.HashSet;
import java.util.Set;

public class Product {
	/* 主键 */
	private Integer id;
	/* 商品名 */
	private String name;
	/* 商品价格 */
	private Double price;
	/* 商品描述 */
	private String description;
	/*订单单向集合*/
	private Set<OrderItem> orderitems = new HashSet<OrderItem>(0);
	
	

	public Product() {
		super();
	}

	public Product(String name, Double price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<OrderItem> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(Set<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}

	
	
}