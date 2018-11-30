package com.wrf.struts.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ClickNumAction extends ActionSupport {
	public String execute() {
		//获取ActionContext对象(ServletAPI)
		ActionContext context = ActionContext.getContext();
		//获取ServletContext 的num属性
		Integer num=(Integer)context.getApplication().get("num");
		if(num==null) {
			num=1;
		}else {
			num++;
		}
		//将加1后的值存储在application中
		context.getApplication().put("num",num);
		return SUCCESS;
	}
	
	
	

}