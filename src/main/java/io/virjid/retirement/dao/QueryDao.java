package io.virjid.retirement.dao;

import java.util.List;

public interface QueryDao<T,ID> {
	T queryById(ID id) throws Exception;
	boolean isExsit(String uk, Object value) throws Exception;
	List<T> queryAll(String orderBy) throws Exception;
}
