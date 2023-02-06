package com.shopeasy.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.shopeasy.core.exception.ServiceException;
import com.shopeasy.core.model.common.CommonEntityList;
import com.shopeasy.core.model.common.Criteria;
import com.shopeasy.core.model.user.MerchantStore;
import com.shopeasy.core.model.user.User;
import com.shopeasy.core.model.user.UserCriteria;

public interface UserService  {
	
	User getUserByName(String UserName) throws ServiceException; 

	User getUserByName(String UserName, String StoreCode) throws ServiceException; 

	User getById(Long id, MerchantStore store) throws ServiceException;
		
	List<User> listUser() throws ServiceException;

	User getByPasswordToken(String storeCode, String token);
	
	void saveOrUpdate(User user) throws ServiceException;
	
	List<User> listByStore(MerchantStore store) throws ServiceException;
	
	User findByStore(Long userId, String storeCode) throws ServiceException;

	CommonEntityList<User> listByCriteria(Criteria criteria ) throws ServiceException;
	
	Page<User> listByCriteria(UserCriteria criteria, int page,int count ) throws ServiceException;
}
