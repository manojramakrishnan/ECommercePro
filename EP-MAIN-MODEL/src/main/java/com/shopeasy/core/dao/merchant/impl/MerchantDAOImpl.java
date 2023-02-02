package com.shopeasy.core.dao.merchant.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.shopeasy.core.dao.merchant.MerchantDAO;
import com.shopeasy.core.repositories.merchant.MerchantRepository;

public class MerchantDAOImpl implements MerchantDAO{

	private MerchantRepository merchantRepository;
	
	@Autowired
	public MerchantDAOImpl (@Qualifier("merchantRepository") MerchantRepository merchantRepository) {
		
		this.merchantRepository= merchantRepository;
	}

	
	@Override
	public boolean isStoreInGroup(String storeCode) {
		// TODO Auto-generated method stub
		return false;
	}

}
