package com.sikiedu.domain;

public class Answer {

	private String id;
	private String content;
	
	private User user;
	private Paste paste;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Paste getPaste() {
		return paste;
	}
	public void setPaste(Paste paste) {
		this.paste = paste;
	}
	
	
	
	
}
