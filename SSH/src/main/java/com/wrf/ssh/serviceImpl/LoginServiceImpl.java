package com.wrf.ssh.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wrf.ssh.dao.UserDao;
import com.wrf.ssh.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
    @Autowired
	private UserDao userDao;
	
	public int login(String userName,String password){
        return userDao.find(userName, password)==null?0:1;
    }
}
