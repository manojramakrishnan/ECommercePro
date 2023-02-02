package com.shopeasy.core.repositories;

import org.hibernate.Criteria;

import com.shopeasy.core.exception.ServiceException;
import com.shopeasy.core.model.common.CommonEntityList;
import com.shopeasy.core.model.user.User;

public interface UserCustomRepository {

	CommonEntityList<User> listByCriteria(Criteria criteria) throws ServiceException;
}
