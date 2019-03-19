package com.netbank.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.netbank.biz.TransactionBiz;
import com.netbank.biz.UserBiz;
import com.netbank.biz.impl.TransactionBizImpl;
import com.netbank.entity.Account;
import com.netbank.entity.Pager;
import com.netbank.entity.TransactionLog;
import com.opensymphony.xwork2.ActionSupport;

public class TransactionAction extends ActionSupport implements RequestAware, SessionAware {
	//使用UserBiz接口声明属性并添加set方法，用于依赖注入
	private UserBiz userBiz;
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}
	
	//使用TransactionBiz接口声明属性并添加set方法，用于依赖注入
	private TransactionBiz transactionBiz;
	public void setTransactionBiz(TransactionBiz transactionBiz) {
		this.transactionBiz = transactionBiz;
	}
	
	private Map<String,Object>session;
	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	private Map<String, Object>request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
		account=(Account)session.get("user");
	}
	
	//声明Account类型属性
	private Account account;
	//定义TransactionLog对象并添加get和set方法，用于封装页面表单参数
	private TransactionLog log;
	public void setLog(TransactionLog log) {
		this.log = log;
	}
	public TransactionLog getLog() {
		return log;
	}
	
	/**
	 * 存款
	 */
	public String deposit(){
		//调用自定义方法isEnable判断账户是否冻结
		if(isEnable()){
			//使用执行isEnable方法从session中重新获取的账户对象
			//给交易信息对象log中关联的账户对象属性赋值
			log.setAccount(account);
			session.put("user",account);
			//调用业务方法，更新账户表Account中的余额
			//并在交易信息表transaction_log中添加交易记录
			return isSuccess(transactionBiz.deposit(log));
		}
		return "message";
	}
	

	//验证账户余额是否充足
	public void validateWithdrawal(){
		//比较取款页面输入的金额与账户余额
		if(log.getTrMoney()>account.getBalance()){
			this.addFieldError("log.trMoney", "您的账户余额不足！");
		}
	}
	

	/**
	 * 取款
	 * @return
	 */
	public String withdrawal(){
		//调用自定义方法isEnable，判断账户是否冻结
		if(isEnable()){
			//使用isEnable方法从Session中重新获取的账户对象 给交易信息对象log关联的账户属性赋值
			log.setAccount(account);
			session.put("user", account);
			//调用业务方法，更新账户表Account中的余额 并在交易信息表transaction_log中添加纪录
			return isSuccess(transactionBiz.withdrawal(log));
		}
		return "message";
	}
	
	//转账校验
	public void validateTransfer(){
		if(log.getOtherid().intValue()==account.getAccountid().intValue()){
			this.addFieldError("log.otherid", "您不能转账给您自己！");
		}
		if(userBiz.getAccount(log.getOtherid())==null){
			this.addFieldError("log.otherid", "该账户不存在！");
		}
		if(log.getTrMoney()>account.getBalance()){
			this.addFieldError("log.trMoney", "您的账户余额不足！");
		}
	}
	
	/**
	 * 转账
	 * @return
	 */
	public String transfer(){
		//调用自定义方法isEnable判断账户是否冻结
		if(isEnable()){
			//使用执行isEnable方法从Session中获取账户对象，给交易信息对象log中关联的账户对象属性赋值
			log.setAccount(account);
			session.put("user",account);
			//调用业务方法，更新转账方和入账方的账户表Account中的余额并在交易信息表transaction_log中添加记录
			return isSuccess(transactionBiz.transfer(log));
		}
		
		return "message";
	}
	
	
	
	
	
	
	
	/**
	 * 自定义方法，根据执行结果，显示操作成功或失败的信息
	 * @param deposit
	 * @return
	 */
	private String isSuccess(boolean flag) {
		if(flag){
			request.put("message", "操作成功!");
			return "message";
		}
		request.put("message", "操作失败！<a href='javascript:history.go(-1)'>返回</a>");
		return "message";
	}
	
	/**
	 * 自定义方法，判断账户是否冻结
	 * @return
	 */
	private boolean isEnable() {
		//从session中重新获取Account对象,该对象在登录成功时已保存到session中
		userBiz.refresh(account);
		if(account.getStatus().getName().equals("冻结")){
			request.put("message", "对不起！该账户也被冻结，无法进行相关操作<br>");
			return false;
		}
		return true;
	}
	
	//分页实体类
	private Pager pager;
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public Pager getPager() {
		return pager;
	}
	
	/**
	 * 显示交易记录
	 * @return
	 */
	public String list(){
		//获取待显示和页页码
		int curPage=pager.getCurPage();
		//根据待显示页码和账户对象获取交易记录
		List<TransactionLog> logs=transactionBiz.getLogs(account, curPage);
		//获得账户的交易记录总数，用来初始化分页类Pager对象，并设置其perPageRows和rowCount属性
		pager=transactionBiz.getPagerOfLogs(account);
		//设置Pager对象中待显示页页码
		pager.setCurPage(curPage);
		request.put("logs", logs);
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
}
