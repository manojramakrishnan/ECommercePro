package com.shopeasy.service;

import com.shopeasy.common.ManagerService;
import com.shopeasy.core.exception.ServiceException;
import com.shopeasy.core.model.user.User;

public interface UserService extends ManagerService<Long, User> {
	
	User getUserByName(String UserName) throws ServiceException; 

}
