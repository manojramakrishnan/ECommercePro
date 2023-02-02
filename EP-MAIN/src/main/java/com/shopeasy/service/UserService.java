package com.shopeasy.service;

import java.util.List;

import com.shopeasy.core.exception.ServiceException;
import com.shopeasy.core.model.user.MerchantStore;
import com.shopeasy.core.model.user.User;

public interface UserService  {
	
	User getUserByName(String UserName) throws ServiceException; 

	User getUserByName(String UserName, String StoreCode) throws ServiceException; 

	User getById(Long id, MerchantStore store) throws ServiceException;
		
	List<User> listUser() throws ServiceException;

	User getByPasswordToken(String storeCode, String token);
	
	void saveOrUpdate(User user) throws ServiceException;
	
	List<User> listByStore(MerchantStore store) throws ServiceException;
	
	User findByStore(Long userId, String storeCode) throws ServiceException;
}
