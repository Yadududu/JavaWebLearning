package com.sikiedu.web.intercept;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

//第一种创建拦截器的方式
public class MyIntercept extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		System.out.println("MyIntercept");
		
		//获取session
		Map<String, Object> session = ActionContext.getContext().getSession();
		//获取session中的user
		Object object = session.get("user");
		//判断sessoin中是否有user数据
		if(object!=null)
		{
			//有,放行
			return invocation.invoke();
		}
		else
		{
			//没有,重定向到login.jsp
			return "toLogin";
		}
		
	}

}
