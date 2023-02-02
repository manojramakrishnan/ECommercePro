package com.shopeasy.service.merchant.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.shopeasy.core.dao.merchant.MerchantDAO;
import com.shopeasy.core.exception.ServiceException;
import com.shopeasy.service.merchant.MerchantService;

public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private MerchantDAO merchantDAO;

	
	
	@Override
	public boolean isStoreInGroup(String storeCode) throws ServiceException {
		// TODO Auto-generated method stub
		return merchantDAO.isStoreInGroup(storeCode);
	}

}
