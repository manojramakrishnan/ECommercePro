package com.shopeasy.common;

import java.io.Serializable;
import java.util.List;

import com.shopeasy.core.exception.ServiceException;

public interface ManagerService<K extends Serializable & Comparable<K>, E extends com.shopeasy.core.model.ManagerEntity<K, ?>>
		extends TransactionalAspectAwareService {

	void save(E entity) throws ServiceException;

	void saveAll(Iterable<E> entities) throws ServiceException;

	void update(E entity) throws ServiceException;

	void create(E entity) throws ServiceException;

	void delete(E entity) throws ServiceException;
	
	E getById(K id);
	
	List<E> list();
	
	Long count();
	
	void flush();

}
