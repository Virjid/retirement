package io.virjid.retirement.service.impl;

import org.springframework.stereotype.Service;

import io.virjid.retirement.ao.AccountAddAo;
import io.virjid.retirement.dao.DoctorDao;
import io.virjid.retirement.dto.DoctorContext;
import io.virjid.retirement.dto.QueryResult;
import io.virjid.retirement.entity.AccountEntity;
import io.virjid.retirement.entity.DoctorEntity;
import io.virjid.retirement.service.DoctorService;

@Service
public class DoctorServiceImpl extends AccountServiceImpl<DoctorDao> implements DoctorService {

	@Override
	public DoctorEntity insert(AccountAddAo ao) throws Exception {
		DoctorEntity entity = super.insert(ao, DoctorEntity.class);
		entity.setOldmans(null);
		dao.insertDoctor(entity);
		return entity;
	}

	@Override
	public DoctorContext queryByAccount(String account) throws Exception {
		DoctorEntity entity = dao.queryByAccount(account);

		DoctorContext result = new DoctorContext();
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
		result.setOldmans(entity.getOldmans());
		
		System.out.println(result.toString());
		return result;
	}
	
	public QueryResult queryByKey(String key, Integer pageNo, Integer pageSize) throws Exception {
		return super.queryByKey(key, pageNo, pageSize, AccountEntity.ROLE_STAFF_DOCTOR);
	}
}
