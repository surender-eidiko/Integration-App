package com.cisco.integrations.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cisco.integrations.model.BitbucketBean;

public class BitbucketDAOImpl implements BitbucketDAO{
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addBitBucketDetails(BitbucketBean bitbucketBean) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(bitbucketBean);
	}

	

}
