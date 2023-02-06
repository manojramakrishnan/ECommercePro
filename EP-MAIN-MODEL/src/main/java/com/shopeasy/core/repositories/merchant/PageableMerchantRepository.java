package com.shopeasy.core.repositories.merchant;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.shopeasy.core.model.user.MerchantStore;

public interface PageableMerchantRepository extends PagingAndSortingRepository<MerchantStore,Long>{

	Page<MerchantStore> listByGroup(String code, Integer integer, String name, Pageable pageRequest);

}
