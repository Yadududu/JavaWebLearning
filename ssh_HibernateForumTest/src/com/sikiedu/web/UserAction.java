package com.sikiedu.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sikiedu.domain.User;
import com.sikiedu.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	public User user = new User();
	
	public String login() throws Exception {
		
		UserService userService = new UserService();
		User temp = userService.findUser(user);
		if(temp!=null)
		{
			ActionContext.getContext().getSession().put("user", temp);
			return "toIndex";
		}
		else
		{
			ActionContext.getContext().put("error", "用户名或者密码错误!!");
			return "login";
		}
		

	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	
}
