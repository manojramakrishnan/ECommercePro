package com.shopeasy.core.repositories;

import com.shopeasy.core.exception.ServiceException;
import com.shopeasy.core.model.common.CommonEntityList;
import com.shopeasy.core.model.common.Criteria;
import com.shopeasy.core.model.user.User;

public interface UserDefinedRepository {

	
	CommonEntityList<User> listByCriteria(Criteria criteria) throws ServiceException;

}
