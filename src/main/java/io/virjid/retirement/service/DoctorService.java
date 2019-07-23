package io.virjid.retirement.service;

import io.virjid.retirement.ao.AccountAddAo;
import io.virjid.retirement.dto.DoctorContext;

public interface DoctorService extends AccountService<DoctorContext, AccountAddAo> {
	@Override
	DoctorContext queryByAccount(String account) throws Exception;
}
