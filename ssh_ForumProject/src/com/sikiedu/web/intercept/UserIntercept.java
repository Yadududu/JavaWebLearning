package com.sikiedu.web.intercept;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserIntercept extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		//获取session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//判断session域中是否有user
		Object object = session.get("user");
		if(object == null)
		{
			//没有-->重定向到login.jsp
			return "toLogin";
		}
		else
		{
			//如果有-->放行
			return invocation.invoke();
		}
		
	}
	
	

}
