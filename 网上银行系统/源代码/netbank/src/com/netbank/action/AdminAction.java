package com.netbank.action;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import com.netbank.biz.PersoninfoBiz;
import com.netbank.biz.UserBiz;
import com.netbank.entity.Account;
import com.netbank.entity.Admin;
import com.netbank.entity.Personinfo;
import com.netbank.entity.Status;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport implements RequestAware, SessionAware {

	//定义通过@Resource注解注入属性personinfoBiz，可省略set方法
		@Resource private PersoninfoBiz personinfoBiz;
		//定义通过@Resource注解注入的属性userBiz，可省略set方法
		@Resource private UserBiz userBiz;
		
		private Map<String,Object> request;
		@Override
		public void setRequest(Map<String, Object> request) {
			this.request=request;
		}
		
		private Map<String,Object> session;
		@Override
		public void setSession(Map<String, Object> session) {
			this.session=session;
		}
		
		//定义Admin类型对象，用于封装管理员登录等页面的表单参数
		private Admin admin;
		public Admin getAdmin(){
			return admin;
		}
		public void setAdmin(Admin admin) {
			this.admin = admin;
		}
		//定义Personinfo类型对象，用于封装页面表单参数
		private Personinfo personinfo;
		public void setPersoninfo(Personinfo personinfo) {
			this.personinfo = personinfo;
		}
		public Personinfo getPersoninfo() {
			return personinfo;
		}
		
		//用来封装从"启用"、“冻结”和“删除”按钮传递来的参数
		private Integer id;
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getId() {
			return id;
		}
		
		
		
		
		/**
		 * 对登录页面进行验证。检查用户名和密码是否正确
		 */
		public void validateLogin(){
			Admin a=userBiz.getAdmin(admin.getUsername());
			if(a==null){
				this.addFieldError("username","用户名不存在");
			}else {
				if(!admin.getPassword().equals(a.getPassword())){
					this.addFieldError("password", "账户或密码不正确");
				}
			}
			admin=a;
		}
		
		/**
		 * 管理员登录
		 * @return
		 */
		public String login(){
			if(admin!=null){
				session.put("admin", admin);
				return "success";
			}
			return "login";
		}
		
		public Status status;
		public void setStatus(Status status) {
			this.status = status;
		}
		public Status getStatus() {
			return status;
		}
		
		public String listUsers(){
			//调用业务方法，根据账户状态获取个人信息，状态为0表示所有客户的信息
			List<Personinfo> users=personinfoBiz.searchPersoninfo(status);
			request.put("users", users);
			return "users";
		}
		
		/**
		 * 查询账户
		 * @return
		 */
		public String search(){
			List<Personinfo> users=personinfoBiz.searchPersoninfo(personinfo);
			request.put("users", users);
			return "users";
		}
		/**
		 * 启用账户
		 * @return
		 */
		public String enabled(){
			userBiz.enabled(id);
			return "list";
		}
		/**
		 * 冻结账户
		 * @return
		 */
		public String locking(){
			userBiz.locking(id);
			return "list";
		}
		
		/**
		 * 删除账户
		 */
		public String del(){
			//调用业务方法，删除账户，同时进行级联删除
			userBiz.delAccount(id);
			return "list";
		}
		
		private Account account;
		public void setAccount(Account account) {
			this.account = account;
		}
		public Account getAccount() {
			return account;
		}
		

		/**
		 * 对开户页面进行校验，验证用户名是否已经存在，一张身份证只能拥有一个账户
		 */
		public void validateKaihu(){
			if(userBiz.getAccount(account.getUsername())!=null){
				this.addFieldError("account.username", "用户名已存在");
			}
			//获取满足条件的个人信息，这里的条件为开户页面中填写的身份证号
			/*List<Personinfo>list=personinfoBiz.searchPersoninfo(personinfo);
			//如果所填写的身份证号在个人信息中已存在，则提示信息错误
			if(list.size()>0){
				this.addFieldError("personinfo.cardid", "一张身份证只能拥有一个账户");
			}*/
		}
		
		//开户
		public String kaihu(){
			//调用业务方法，向账户表Account中添加个人信息
			userBiz.addAccount(account);
			//调用业务方法，向个人信息表personinfo添加个人信息
			account=userBiz.getAccount(account.getUsername());
			personinfo.setAccount(account);
			personinfoBiz.add(personinfo);
			request.put("message", "添加成功");
			return "message";
		}
		
		
		
		
		
		
		

}
