package com.shopeasy.core.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.shopeasy.core.exception.ServiceException;
import com.shopeasy.core.model.common.CommonEntityList;
import com.shopeasy.core.model.common.Criteria;
import com.shopeasy.core.model.user.User;
import com.shopeasy.core.model.user.UserCriteria;


public interface UserDAO {

	User findByUserName(String userName) throws ServiceException;

	User findByUserName(String userName, String storeCode);



	List<User> findAll();

	User findById(Long id, String code);

	User getByPasswordToken(String storeCode, String token);

	void saveOrUpdate(User user);

	List<User> listByStore(Integer id);

	User findByStore(Long userId, String storeCode,boolean isFound);

	CommonEntityList<User> listByCriteria(Criteria criteria) throws ServiceException;

	Page<User> listByCriteria(UserCriteria criteria, int page, int count);

}
