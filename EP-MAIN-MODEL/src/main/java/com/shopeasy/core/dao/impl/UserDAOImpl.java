package com.shopeasy.core.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.shopeasy.core.dao.UserDAO;
import com.shopeasy.core.exception.ServiceException;
import com.shopeasy.core.model.user.MerchantStore;
import com.shopeasy.core.model.user.User;
import com.shopeasy.core.repositories.UserRepository;

@Component("userDAO")
public class UserDAOImpl implements UserDAO{
	
	
	
	private UserRepository userRepository;
	
	@Autowired
	private MerchantStoreService merchantStoreService;
	
	@Autowired
	public UserDAOImpl (@Qualifier("userRepository") UserRepository userRepository) {
		
		this.userRepository= userRepository;
	}

	@Override
	public User findByUserName(String userName) throws ServiceException {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(userName);
	}

	@Override
	public User findByUserName(String userName, String storeCode) {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(userName,storeCode);
	}

	

	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		
		return userRepository.findAll();
				
		}

	@Override
	public User findById(Long id, String code) {
		// TODO Auto-generated method stub
		return userRepository.findById(id, code);
	}

	@Override
	public User getByPasswordToken(String storeCode, String token) {
		// TODO Auto-generated method stub
		return userRepository.findByResetPasswordToken(token,storeCode);
	}

	@Override
	public void saveOrUpdate(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
		
	}

	@Override
	public List<User> listByStore(Integer id) {
		// TODO Auto-generated method stub
		return userRepository.findByStore(id);
	}

	@Override
	public User findByStore(Long userId, String storeCode) {
		// TODO Auto-generated method stub
		User user= userRepository.findOne(userId);
		boolean isFound = merchantStoreService.isStoreInGroup(storeCode);
		return null;
	}

}
