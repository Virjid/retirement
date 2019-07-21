package io.virjid.retirement.service.impl;

import org.springframework.stereotype.Service;

import io.virjid.retirement.ao.OldmanAddAo;
import io.virjid.retirement.dao.OldmanDao;
import io.virjid.retirement.dto.QueryResult;
import io.virjid.retirement.entity.AccountEntity;
import io.virjid.retirement.entity.OldmanEntity;
import io.virjid.retirement.service.OldmanService;

@Service
public class OldmanServiceImpl extends AccountServiceImpl<OldmanDao> implements OldmanService {

	@Override
	public OldmanEntity insert(OldmanAddAo ao) throws Exception {
		OldmanEntity entity = super.insert(ao, OldmanEntity.class);
		entity.setDoctorId(ao.getDoctorId());
		entity.setNurseId(ao.getNurseId());
		entity.setCareId(ao.getCareId());
		dao.insertOldman(entity);
		return entity;
	}
	
	public QueryResult queryByKey(String key, Integer pageNo, Integer pageSize) throws Exception {
		return super.queryByKey(key, pageNo, pageSize, AccountEntity.ROLE_USER_OLDMAN);
	}
}
