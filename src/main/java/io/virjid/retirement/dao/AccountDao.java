package io.virjid.retirement.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import io.virjid.retirement.entity.AccountEntity;

public interface AccountDao extends CUDDao<AccountEntity, String>,QueryDao<AccountEntity, String> {
	
	<T extends AccountEntity> T queryByAccount(String account);
	
	Boolean isExistByAccount(String account);

	List<AccountEntity> selectByKey(@Param("key")String key, @Param("pageNo")Integer pageNo, @Param("pageSize")Integer pageSize, @Param("role")Integer role);
	
	void modifyPassword(@Param("id")String id, @Param("password")String password);
}
