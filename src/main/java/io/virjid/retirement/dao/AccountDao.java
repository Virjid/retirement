package io.virjid.retirement.dao;

import io.virjid.retirement.entity.AccountEntity;

public interface AccountDao extends CUDDao<AccountEntity, String>,QueryDao<AccountEntity, String> {
	
	AccountEntity queryByAccount(String account);
	
	Boolean isExistByAccount(String account);
}
