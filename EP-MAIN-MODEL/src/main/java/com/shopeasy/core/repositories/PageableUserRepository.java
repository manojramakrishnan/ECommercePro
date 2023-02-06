package com.shopeasy.core.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.shopeasy.core.model.user.User;

public interface PageableUserRepository extends PagingAndSortingRepository<User,Long>{

	Page<User> listByStoreIds(List<Integer> storeIds, String adminEmail, Pageable pageRequest);

	Page<User> listAll(String adminEmail, Pageable pageRequest);

	Page<User> listByStore(String storeCode, String adminEmail, Pageable pageRequest);

}
