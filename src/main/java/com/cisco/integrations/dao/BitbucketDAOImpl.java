package com.cisco.integrations.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cisco.integrations.model.BitbucketDetails;

public class BitbucketDAOImpl implements BitbucketDAO{
	
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addBitBucketDetails(BitbucketDetails bitbucketDetails) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(bitbucketDetails);
	}

	

}
