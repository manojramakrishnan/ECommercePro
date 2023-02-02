package com.shopeasy.core.model.common;

import java.util.List;

public class CommonEntityList <T> extends EntityList {

	private static final long serialVersionUID=1l;
	List<T> list;
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
