package com.shopeasy.core.model.common;

import java.util.List;

public class Criteria {

	private int startIndex=0;
	private int maxCount=0;
	private int startPage=0;
	private int pageSize=0;
	private boolean legacyPagination=true;
	private String code;
	private String name;
	private String language;
	private String user;
	private String storeCode;
	private List<Integer> storeIds;
	private CriteriaOrderBy orderBy = CriteriaOrderBy.DESC;
	private String criterOrderByField;
	private String search;
	
	
	public CriteriaOrderBy getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(CriteriaOrderBy orderBy) {
		this.orderBy = orderBy;
	}
	public String getCriterOrderByField() {
		return criterOrderByField;
	}
	public void setCriterOrderByField(String criterOrderByField) {
		this.criterOrderByField = criterOrderByField;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public boolean isLegacyPagination() {
		return legacyPagination;
	}
	public void setLegacyPagination(boolean legacyPagination) {
		this.legacyPagination = legacyPagination;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public List<Integer> getStoreIds() {
		return storeIds;
	}
	public void setStoreIds(List<Integer> storeIds) {
		this.storeIds = storeIds;
	}
	
}
