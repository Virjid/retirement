package io.virjid.retirement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.virjid.retirement.ao.AccountAddAo;
import io.virjid.retirement.common.StringHelper;
import io.virjid.retirement.dao.AccountDao;
import io.virjid.retirement.dto.AccountContext;
import io.virjid.retirement.entity.AccountEntity;
import io.virjid.retirement.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService, StringHelper {
	@Autowired
	private AccountDao accountDao;

	@Override
	public AccountContext queryByAccount(String account) {
		AccountEntity entity = accountDao.queryByAccount(account);
		
		AccountContext result = new AccountContext();
		result.setAccount(entity.getAccount());
		result.setAddress(entity.getAddress());
		result.setBirthday(entity.getBirthday());
		result.setContact(entity.getContact());
		result.setId(entity.getId());
		result.setIdCard(entity.getIdCard());
		result.setMale(entity.isMale());
		result.setName(entity.getName());
		result.setRole(entity.getRole());
		result.setStatus(entity.getStatus());
		
		return result;
	}

	@Override
	public void insert(AccountAddAo ao) throws Exception {
		AccountEntity entity = new AccountEntity();
		entity.setAccount(ao.getAccount());
		entity.setAddress(ao.getAddress());
		entity.setBirthday(ao.getBirthday());
		entity.setContact(ao.getContact());
		entity.setId(uuid());
		entity.setIdCard(ao.getIdCard());
		entity.setRole(ao.getRole());
		entity.setStatus(ao.getStatus());
		entity.setPassword(ao.getPassword());
		entity.setMale(ao.isMale());
		entity.setName(ao.getName());
		
		accountDao.insert(entity);
	}
}
