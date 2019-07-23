package io.virjid.retirement.service.impl;

import org.springframework.stereotype.Service;

import io.virjid.retirement.ao.AccountAddAo;
import io.virjid.retirement.dao.DoctorDao;
import io.virjid.retirement.dto.DoctorContext;
import io.virjid.retirement.dto.QueryResult;
import io.virjid.retirement.entity.AccountEntity;
import io.virjid.retirement.entity.DoctorEntity;
import io.virjid.retirement.service.AbstractAccountService;
import io.virjid.retirement.service.DoctorService;

@Service
public class DoctorServiceImpl extends AbstractAccountService<DoctorDao> implements DoctorService {

	@Override
	public DoctorContext insert(AccountAddAo ao) throws Exception {
		DoctorEntity entity = super.insert(ao, DoctorEntity.class);
		entity.setOldmans(null);
		dao.insertDoctor(entity);
		
		DoctorContext context = new DoctorContext();
		return context;
	}

	@Override
	public DoctorContext queryByAccount(String account) throws Exception {
		DoctorEntity entity = dao.queryByAccount(account);

		DoctorContext result = new DoctorContext();
		fillAccountContext(result, entity);
		result.setOldmans(entity.getOldmans());
		
		return result;
	}
	
	@Override
	public QueryResult queryByKey(String key, Integer pageNo, Integer pageSize) throws Exception {
		return super.queryByKey(key, pageNo, pageSize, AccountEntity.ROLE_STAFF_DOCTOR);
	}

//	@Override
//	public AccountEntity modifyAccount(String id, Map<String, String> ao) throws Exception {
//		
//		return null;
//	}
}
