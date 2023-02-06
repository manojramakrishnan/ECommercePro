package com.shopeasy.service.impl;

import java.util.List;

import org.jsoup.helper.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import com.shopeasy.core.dao.UserDAO;
import com.shopeasy.core.exception.ServiceException;
import com.shopeasy.core.model.common.CommonEntityList;
import com.shopeasy.core.model.common.Criteria;
import com.shopeasy.core.model.user.MerchantStore;
import com.shopeasy.core.model.user.User;
import com.shopeasy.core.model.user.UserCriteria;
import com.shopeasy.service.UserService;
import com.shopeasy.service.merchant.MerchantService;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private MerchantService merchantService;
	
	
	
	@Override
	public User getUserByName(String UserName) throws ServiceException {
		// TODO Auto-generated method stub
		return userDAO.findByUserName(UserName);
	}


	@Override
	public User getUserByName(String UserName, String StoreCode) throws ServiceException {
		// TODO Auto-generated method stub
		return userDAO.findByUserName(UserName,StoreCode);
	}


	@Override
	public User getById(Long id, MerchantStore store) throws ServiceException {
		// TODO Auto-generated method stub
		Validate.notNull(store,"MerchantStore cannot be null");
		return userDAO.findById(id,store.getCode());
	}


	@Override
	public List<User> listUser() throws ServiceException {
		// TODO Auto-generated method stub
		try {
			return userDAO.findAll();
		}
		catch (Exception e){
			throw new ServiceException(e);
					}
		
	}


	@Override
	public User getByPasswordToken(String storeCode, String token) {
		// TODO Auto-generated method stub
		return userDAO.getByPasswordToken(storeCode,token);
	}


	@Override
	public void saveOrUpdate(User user) throws ServiceException {
		// TODO Auto-generated method stub
		userDAO.saveOrUpdate(user);
		
	}


	@Override
	public List<User> listByStore(MerchantStore store) throws ServiceException {
		// TODO Auto-generated method stub
		try {
		return userDAO.listByStore(store.getId());
	
		}
		catch(Exception e) {
			throw new ServiceException();
		}
		}


	@Override
	public User findByStore(Long userId, String storeCode) throws ServiceException {
		// TODO Auto-generated method stub
		boolean isFound = merchantService.isStoreInGroup(storeCode);
		return userDAO.findByStore(userId,storeCode,isFound);
	}


	@Override
	public CommonEntityList<User> listByCriteria(Criteria criteria) throws ServiceException {
		// TODO Auto-generated method stub
		return userDAO.listByCriteria(criteria);
	}


	@Override
	public Page<User> listByCriteria(UserCriteria criteria, int page, int count) throws ServiceException {
		// TODO Auto-generated method stub
		return userDAO.listByCriteria(criteria,page,count);
	}


		
	

}
