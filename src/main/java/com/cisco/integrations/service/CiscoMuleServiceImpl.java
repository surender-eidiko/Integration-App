package com.cisco.integrations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cisco.integrations.dao.BitbucketDAO;
import com.cisco.integrations.model.BitbucketDetails;

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
	public void addBitBucketDetails(BitbucketDetails bitbucketDetails) {
		try{
			this.bitbucketDAO.addBitBucketDetails(bitbucketDetails);
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	

}
