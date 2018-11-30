package com.wrf.ssh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wrf.ssh.entity.User;
import com.wrf.ssh.service.LoginService;

@Controller  //注解为控制器
@RequestMapping(value="/login")    //截获带有/login的请求
public class LoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(method=RequestMethod.GET)
    public String get(){  //用来返回一个页面
        return "login";  //返回指向login.jsp页面
    }

    @RequestMapping(method=RequestMethod.POST)
    public String post(User user){  //用来处理用户的登陆请求
       if(loginService.login(user.getUserName(), user.getPassword())==1) {
    	   return "login_success";
       }else {
    	   return "login";
       }
    }
}

