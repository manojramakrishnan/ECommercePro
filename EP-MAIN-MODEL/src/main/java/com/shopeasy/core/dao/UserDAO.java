package com.shopeasy.core.dao;

import java.util.List;

import com.shopeasy.core.exception.ServiceException;
import com.shopeasy.core.model.user.User;


public interface UserDAO {

	User findByUserName(String userName) throws ServiceException;

	User findByUserName(String userName, String storeCode);



	List<User> findAll();

	User findById(Long id, String code);

	User getByPasswordToken(String storeCode, String token);

	void saveOrUpdate(User user);

	List<User> listByStore(Integer id);

	User findByStore(Long userId, String storeCode);

}
