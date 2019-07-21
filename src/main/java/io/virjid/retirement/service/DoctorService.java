package io.virjid.retirement.service;

import io.virjid.retirement.ao.AccountAddAo;
import io.virjid.retirement.dto.DoctorContext;
import io.virjid.retirement.entity.DoctorEntity;

public interface DoctorService extends AccountService {
	DoctorEntity insert(AccountAddAo ao) throws Exception;
	DoctorContext queryByAccount(String account) throws Exception;
}
