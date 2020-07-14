package com.sikiedu.dao;

import org.hibernate.Session;

import com.sikiedu.domain.Answer;
import com.sikiedu.utils.HibernateUtils;

public class AnswerDao {

	public void addAnswer(Answer answer) {
		
		Session session = HibernateUtils.getCurrentSession();
		session.save(answer);
		
	}

}
