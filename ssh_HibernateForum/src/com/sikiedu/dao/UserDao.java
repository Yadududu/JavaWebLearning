package com.sikiedu.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sikiedu.domain.User;
import com.sikiedu.utils.HibernateUtils;

public class UserDao {

	public void addUser() {
		
		
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		
		User user = new User();//=>没有id.没有与session关联   瞬时状态
		user.setName("lain");//=>没有id.没有与session关联   瞬时状态
		
		//存储user对象 save    只是为了生成id
		session.save(user); //有id,与session关联   持久化状态  本质:对象状态的转换
							//将瞬时->持久    目的 : 生成id
		
		System.out.println(user.getId());//在这里就有了id,但是数据还没保存到数据库
		
		System.out.println("//////////////////////////////////////");
		//提交事务
		transaction.commit();
		//关闭资源
		session.close();//没有与session关联,有id   游离态
		
		System.out.println(user.getId());
		
	}
	

	public void deleteUser()
	{
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		//得到id为e02e172c-f7ea-4866-85a3-98cb5a0e9bc5的对象
		User user = session.get(User.class, "4028818764d1723c0164d17240270000");
		session.delete(user);
		transaction.commit();
		System.out.println(user.getId());
		session.close();
		
	}
	
	public void ChangeUser()
	{
		//读取hibernate.cfg.xml
		Configuration config = new Configuration().configure();
		//获取sessionFactory工厂
		SessionFactory factory = config.buildSessionFactory();
		//获取session
		Session session = factory.openSession();
		//开启事务
		Transaction beginTransaction = session.beginTransaction();
		
		
		//获得id为4028818764d04c020164d04c08040000的对象
		//有id,与session有关联     持久化状态 
		User user = session.get(User.class, "1");
		User user1 = session.get(User.class, "1");
		User user2 = session.get(User.class, "1");
		User user3 = session.get(User.class, "1");
		User user4 = session.get(User.class, "1");
		//缓存的存在
		System.out.println(user2 == user4);
		
		//将该对象改名为lain
		//user.setUsername("lain");
		//更新数据库
		//session.update(user);
		
		
		
		//提交事务
		beginTransaction.commit();
		//关闭session
		session.close();
	}
	
	public void findUser()
	{
		Configuration config = new Configuration().configure();
		SessionFactory factory = config.buildSessionFactory();
		Session openSession = factory.openSession();
		Transaction beginTransaction = openSession.beginTransaction();
		User user = openSession.get(User.class, "4028818764d04c020164d04c08040000");
		System.out.println(user.getName());
		beginTransaction.commit();
		openSession.close();
	}


	public User findUserById(String id) {
		
		Session session = HibernateUtils.getCurrentSesssion();
		return session.get(User.class, id);
	}


	public void ChangeUserByUserId(String id) {
		
		Session session =  HibernateUtils.getCurrentSesssion();
		//先拿到持久化user
		User user = session.get(User.class, id);
		//改变user (持久化->beginTransaction.commit()他才会同步到数据库)
		user.setUsername("trigger");
		
	}
	

}
