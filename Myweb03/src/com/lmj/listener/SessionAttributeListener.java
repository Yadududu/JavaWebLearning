package com.lmj.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.lmj.model.User;
import com.lmj.util.SessionManager;

/**
 * Application Lifecycle Listener implementation class SessionAttributeListener
 *
 */
//@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public SessionAttributeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
//    	System.out.println("attributeAdded");
    	if(arg0.getName().equals("user")) {
    		User user = (User)arg0.getValue();
    		if(SessionManager.sessionMap.containsKey(user.getUsername())) {
    			HttpSession session =  SessionManager.sessionMap.get(user.getUsername());
    			session.removeAttribute("user");
    			SessionManager.sessionMap.remove(user.getUsername());
    		}
    		
    		SessionManager.sessionMap.put(user.getUsername(), arg0.getSession());
    	}
    	
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
