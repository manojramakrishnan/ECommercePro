package com.shopeasy.core.repositories.merchant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopeasy.core.model.user.MerchantStore;

public interface MerchantRepository extends JpaRepository<MerchantStore,Integer>{

	MerchantStore findByCode(String storeCode);

	List<MerchantStore> listByGroup(String storeCode, Integer integer);

}
