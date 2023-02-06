package com.shopeasy.service.merchant.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.shopeasy.core.dao.merchant.MerchantDAO;
import com.shopeasy.core.exception.ServiceException;
import com.shopeasy.core.model.user.MerchantStore;
import com.shopeasy.service.merchant.MerchantService;

public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private MerchantDAO merchantDAO;

	
	
	@Override
	public boolean isStoreInGroup(String storeCode) throws ServiceException {
		// TODO Auto-generated method stub
		return merchantDAO.isStoreInGroup(storeCode);
	}



	@Override
	public Page<MerchantStore> listByGroup(Optional<String> StoreName, String code, int page, int count)
			throws ServiceException {
		// TODO Auto-generated method stub
		
		return merchantDAO.listByGroup(StoreName,code,page,count);
	}

}
