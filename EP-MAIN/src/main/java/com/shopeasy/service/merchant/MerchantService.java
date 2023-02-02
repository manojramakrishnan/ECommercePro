package com.shopeasy.service.merchant;

import com.shopeasy.core.exception.ServiceException;

public interface MerchantService {

	boolean isStoreInGroup(String storeCode) throws ServiceException;
}
