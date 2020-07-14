package com.sikiedu.dao;

import org.hibernate.Session;

import com.sikiedu.domain.Paste;
import com.sikiedu.utils.HibernateUtils;

public class PasteDao {

	public void addPaste(Paste paste) {
		
		Session session = HibernateUtils.getCurrentSession();
		session.save(paste);
		
	}

	public Paste findPasteById(String pasteid) {
		
		Session session = HibernateUtils.getCurrentSession();
		return session.get(Paste.class, pasteid);

	}

}
