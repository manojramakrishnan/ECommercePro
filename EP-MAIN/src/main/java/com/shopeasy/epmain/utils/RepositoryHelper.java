package com.shopeasy.epmain.utils;

import javax.persistence.Query;

import com.shopeasy.core.model.common.CommonEntityList;
import com.shopeasy.core.model.common.Criteria;

public class RepositoryHelper {

	public static Query paginateQuery (Query q,Number count, CommonEntityList entityList,Criteria criteria ) {

	if (entityList == null) {
		entityList = new CommonEntityList();
	}

	if (criteria.isLegacyPagination()) {
		if (criteria.getMaxCount() > 0) {
			q.setFirstResult(criteria.getStartIndex());
			q.setMaxResults(Math.min(criteria.getMaxCount(), count.intValue()));
		}
	} else {
		//int firstResult = ((criteria.getStartPage()==0?criteria.getStartPage()+1:criteria.getStartPage()) - 1) * criteria.getPageSize();
		int firstResult = ((criteria.getStartPage()==0?0:criteria.getStartPage())) * criteria.getPageSize();
		q.setFirstResult(firstResult);
		q.setMaxResults(criteria.getPageSize());
		int lastPageNumber = (count.intValue() / criteria.getPageSize()) + 1;
		entityList.setTotalPages(lastPageNumber);
		entityList.setTotalCount(count.intValue());
	}

	return q;

	}
}
