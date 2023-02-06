package com.shopeasy.core.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;

import com.shopeasy.core.exception.ServiceException;
import com.shopeasy.core.model.common.CommonEntityList;
import com.shopeasy.core.model.common.Criteria;
import com.shopeasy.core.model.common.utils.RepositoryHelper;
import com.shopeasy.core.model.user.User;

public class UserRepositoryImpl implements UserDefinedRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public CommonEntityList<User> listByCriteria(Criteria criteria) throws ServiceException {
		// TODO Auto-generated method stub
		try {
			StringBuilder req= new StringBuilder();
			req.append("Select distinct u from User as u left join fetch u.groups ug left join fetch u.defaultLanguage ud join fetch u.merchantStore um");
			StringBuilder countBuilder=new StringBuilder();
			countBuilder.append("select Count(distinct u) from User as u join u.merchantStore um");
			if(!StringUtils.isBlank(criteria.getStoreCode())) {
				req.append(" where um.code=:storeCode");
				countBuilder.append(" where um.code=:storeCode");
			}
			if(!StringUtils.isBlank(criteria.getCriterOrderByField())) {
				req.append("order by u." + criteria.getCriterOrderByField() + " " + criteria.getOrderBy().name().toUpperCase());
			}
			Query countQ= this.em.createQuery(countBuilder.toString());
			String hql=req.toString();
			Query q= this.em.createQuery(hql);
			if(!StringUtils.isBlank(criteria.getSearch())) {
				
			}
			else {
				if(criteria.getStoreCode()!=null) {
					countQ.setParameter("storeCode", criteria.getStoreCode());
					q.setParameter("storeCode", criteria.getStoreCode());
					
				}
			}
		Number count= (Number) countQ.getSingleResult();
		CommonEntityList entityList= new CommonEntityList();
		entityList.setTotalCount(count.intValue());
		q= RepositoryHelper.paginateQuery(q,count,entityList,criteria);
		List<User> users= q.getResultList();
		entityList.setList(users);
		return entityList;
		}
		catch(javax.persistence.NoResultException ers) {
			
		}
		catch(Exception e) {
			throw new ServiceException();
		}
		return null;
		
	}
	
}
