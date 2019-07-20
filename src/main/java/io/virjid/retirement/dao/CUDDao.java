package io.virjid.retirement.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
/**
 * 增删改
 * @author Administrator
 *
 */
public interface CUDDao<E,ID> {
	void insert(E e)throws Exception;
	void delete(ID id)throws Exception;
	void update(@Param("id")
			ID id,@Param("e")Map<String,Object> map)throws Exception;
}
