package com.shopeasy.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopeasy.core.model.user.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>, UserCustomRepository {

	User findByUserName(String UserName);

	User findByUserName(String userName, String storeCode);

	User findByUserId(String userId, String storeCode);

	List<User> listAll();

	User findById(Long id, String code);

	User findByResetPasswordToken(String token, String storeCode);

	List<User> findByStore(Integer id);

	User findOne(Long userId);
	
	
}
