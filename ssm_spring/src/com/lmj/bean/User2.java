package com.lmj.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//<bean name="user" class="com.lmj.bean.User">
@Component("user")

//@Controller()		//��Ӧweb��
//@Service("user")	//��Ӧservice
//@Repository()		//��Ӧdao��
//@Scope(scopeName="prototype")
public class User2 {
	
	@Value(value="1")	//ʹ�ñ�������ȥע���
	private Integer u_id;	
	private String u_username;
	private String u_password;
	
	//��������ֶ�
	private Pet u_pet;
	
	public Pet getU_pet() {
		return u_pet;
	}

	//�Զ�װ��
//	@Autowired
	//�ֶ�ָ��
	@Resource(name="dog")
	public void setU_pet(Pet u_pet) {
		this.u_pet = u_pet;
	}

	public User2() {
		System.out.println("User2 ����ղι��췽��");
	}
	
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getU_username() {
		return u_username;
	}
	
	@Value("����")	//�Ƽ���set������ע��
	public void setU_username(String u_username) {
		this.u_username = u_username;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	
	//�ڹ��췽�������
	@PostConstruct()
	public void userInit() {
		System.out.println("user init ");
	}
		
	//�����ٷ���ǰ����
	@PreDestroy()
	public void userDestroy() {
		System.out.println("user destroy");
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_username=" + u_username + ", u_password=" + u_password + ", u_pet=" + u_pet
				+ "]";
	}
	

	
}