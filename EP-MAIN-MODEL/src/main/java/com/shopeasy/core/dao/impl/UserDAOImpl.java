package com.shopeasy.core.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.shopeasy.core.dao.UserDAO;
import com.shopeasy.core.exception.ServiceException;
import com.shopeasy.core.model.common.CommonEntityList;
import com.shopeasy.core.model.common.Criteria;
import com.shopeasy.core.model.user.User;
import com.shopeasy.core.model.user.UserCriteria;
import com.shopeasy.core.repositories.PageableUserRepository;
import com.shopeasy.core.repositories.UserRepository;

@Component("userDAO")
public class UserDAOImpl implements UserDAO{
	
	
	
	private UserRepository userRepository;
	
	@Autowired
	private PageableUserRepository pageableUserRepository;
	
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
	public User findByStore(Long userId, String storeCode,boolean isFound) {
		// TODO Auto-generated method stub
		User user= userRepository.findOne(userId);
		if(isFound) {
			return user;
		}
		
		return null;
	}

	@Override
	public CommonEntityList<User> listByCriteria(Criteria criteria) throws ServiceException {
		// TODO Auto-generated method stub
		return userRepository.listByCriteria(criteria);
	}

	@Override
	public Page<User> listByCriteria(UserCriteria criteria, int page, int count) {
		// TODO Auto-generated method stub
		Pageable pageRequest= PageRequest.of(page, count);
		Page<User> users=null;
		if(criteria.getStoreIds()!=null) {
			users=pageableUserRepository.listByStoreIds(criteria.getStoreIds(),criteria.getAdminEmail(),pageRequest);
		}
		else if(StringUtils.isBlank(criteria.getStoreCode())) {
			users= pageableUserRepository.listAll(criteria.getAdminEmail(),pageRequest);
		}
		else if(criteria.getStoreCode()!=null) {
			users=pageableUserRepository.listByStore(criteria.getStoreCode(),criteria.getAdminEmail(),pageRequest);
		}
		return users;
	}

}
