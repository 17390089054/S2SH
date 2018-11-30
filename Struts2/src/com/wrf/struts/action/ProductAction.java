package com.wrf.struts.action;

import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport{
	private int productId;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	//编辑商品
	public String edit() {
		System.out.println("编辑商品"+ productId);
		return "edit";
	}
	
	//删除商品
	public String del() {
		System.out.println("删除商品"+ productId);
		return "del";
	}
	
}
