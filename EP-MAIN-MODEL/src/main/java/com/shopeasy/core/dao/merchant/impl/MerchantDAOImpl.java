package com.shopeasy.core.dao.merchant.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.shopeasy.core.dao.merchant.MerchantDAO;
import com.shopeasy.core.model.user.MerchantStore;
import com.shopeasy.core.repositories.merchant.MerchantRepository;
import com.shopeasy.core.repositories.merchant.PageableMerchantRepository;

public class MerchantDAOImpl implements MerchantDAO{

	private MerchantRepository merchantRepository;
	
	@Autowired
	private PageableMerchantRepository pageableMerchantRepository;
	
	@Autowired
	public MerchantDAOImpl (@Qualifier("merchantRepository") MerchantRepository merchantRepository) {
		
		this.merchantRepository= merchantRepository;
	}

	
	@Override
	public boolean isStoreInGroup(String storeCode) {
		// TODO Auto-generated method stub
		MerchantStore store =getByCode(storeCode);
		Optional<Integer> id =Optional.ofNullable(store.getId());
		List<MerchantStore> stores = merchantRepository.listByGroup(storeCode,id.get());
		return stores.size()>0;
	}


	
	private MerchantStore getByCode(String storeCode) {
		// TODO Auto-generated method stub
		
		return merchantRepository.findByCode(storeCode);
	}


	@Override
	public Page<MerchantStore> listByGroup(Optional<String> storeName, String code, int page, int count) {
		// TODO Auto-generated method stub
		String name=null;
		if(storeName!=null && storeName.isPresent()) {
			name=storeName.get();
		}
		MerchantStore store =getByCode(code);
		Optional<Integer> id = Optional.ofNullable(store.getId());
		Pageable pageRequest= PageRequest.of(page, count);
		return pageableMerchantRepository.listByGroup(code,id.get(),name,pageRequest);
	}

	
}
