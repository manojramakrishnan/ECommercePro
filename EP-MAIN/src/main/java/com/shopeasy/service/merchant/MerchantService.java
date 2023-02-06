package com.shopeasy.service.merchant;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.shopeasy.core.exception.ServiceException;
import com.shopeasy.core.model.user.MerchantStore;

public interface MerchantService {

	boolean isStoreInGroup(String storeCode) throws ServiceException;
	
	Page<MerchantStore> listByGroup(Optional<String> StoreName,String code, int page, int count) throws ServiceException;
}
