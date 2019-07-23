package io.virjid.retirement.service;

import java.util.Map;

import io.virjid.retirement.ao.AccountAddAo;
import io.virjid.retirement.ao.AccountModPasswordAo;
import io.virjid.retirement.dto.AccountContext;
import io.virjid.retirement.dto.QueryResult;
import io.virjid.retirement.entity.AccountEntity;

public interface AccountService<C extends AccountContext, A extends AccountAddAo> {
	AccountContext queryByAccount(String account) throws Exception;
	
	QueryResult queryByKey(String key, Integer pageNo, Integer pageSize) throws Exception;
	
	C insert(A ao) throws Exception;
	
	void delete(String id) throws Exception;
	
	AccountEntity modifyAccount(String id, Map<String,String> ao)throws Exception;
	
	AccountEntity modifyPassword(AccountModPasswordAo ao)throws Exception;
}
