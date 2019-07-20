package io.virjid.retirement.service;

import io.virjid.retirement.ao.AccountAddAo;
import io.virjid.retirement.dto.AccountContext;

public interface AccountService {
	public AccountContext queryByAccount(String account) throws Exception;
	
	public void insert(AccountAddAo ao) throws Exception;
}
