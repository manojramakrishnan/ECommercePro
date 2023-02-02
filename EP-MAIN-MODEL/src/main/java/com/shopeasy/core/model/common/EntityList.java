package com.shopeasy.core.model.common;

import java.io.Serializable;

public class EntityList implements Serializable{
	
	private static final long serialVersionUID=1l;
	private long totalCount;
	private int totalPages;
	
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPages() {
		return totalPages ==0 ? totalPages+1:totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}
