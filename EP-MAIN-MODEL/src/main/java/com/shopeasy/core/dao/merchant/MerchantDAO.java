package com.shopeasy.core.dao.merchant;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.shopeasy.core.model.user.MerchantStore;

public interface MerchantDAO {

	boolean isStoreInGroup(String storeCode);

	Page<MerchantStore> listByGroup(Optional<String> storeName, String code, int page, int count);

}
