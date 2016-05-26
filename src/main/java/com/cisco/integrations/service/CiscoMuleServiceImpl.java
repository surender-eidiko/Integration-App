package com.cisco.integrations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.integrations.dao.BitbucketDAO;
import com.cisco.integrations.model.BitbucketBean;

@Service
public class CiscoMuleServiceImpl implements CiscoMuleService{
	
	@Autowired
	private BitbucketDAO bitbucketDAO;

	

	public BitbucketDAO getBitbucketDAO() {
		return bitbucketDAO;
	}



	public void setBitbucketDAO(BitbucketDAO bitbucketDAO) {
		this.bitbucketDAO = bitbucketDAO;
	}



	@Override
	public void addBitBucketDetails(BitbucketBean bitbucketBean) {
		try{
			this.bitbucketDAO.addBitBucketDetails(bitbucketBean);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	

}
