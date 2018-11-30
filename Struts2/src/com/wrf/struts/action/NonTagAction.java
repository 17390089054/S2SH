package com.wrf.struts.action;

import com.opensymphony.xwork2.ActionSupport;

public class NonTagAction extends ActionSupport{
	public String execute() {
		addActionError("封装error信息");
		addActionError("封装message信息");
		return SUCCESS;
	}
	
}
