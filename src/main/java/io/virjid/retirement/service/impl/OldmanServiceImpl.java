package io.virjid.retirement.service.impl;

import static io.virjid.retirement.common.validator.ValidateHelper.$;

import java.util.Objects;

import org.springframework.stereotype.Service;

import io.virjid.retirement.ao.OldmanAddAo;
import io.virjid.retirement.dao.OldmanDao;
import io.virjid.retirement.dto.OldmanContext;
import io.virjid.retirement.dto.QueryResult;
import io.virjid.retirement.entity.AccountEntity;
import io.virjid.retirement.entity.CareEntity;
import io.virjid.retirement.entity.DoctorEntity;
import io.virjid.retirement.entity.NurseEntity;
import io.virjid.retirement.entity.OldmanEntity;
import io.virjid.retirement.exception.ThisSystemException;
import io.virjid.retirement.service.AbstractAccountService;
import io.virjid.retirement.service.OldmanService;

@Service
public class OldmanServiceImpl extends AbstractAccountService<OldmanDao> implements OldmanService {

	@Override
	public OldmanContext insert(OldmanAddAo ao) throws Exception {
		OldmanEntity entity = super.insert(ao, OldmanEntity.class);
		entity.setDoctorId(ao.getDoctorId());
		entity.setNurseId(ao.getNurseId());
		entity.setCareId(ao.getCareId());
		dao.insertOldman(entity);
		
		OldmanContext context = new OldmanContext();
		DoctorEntity doctor = new DoctorEntity();
		doctor.setId(ao.getDoctorId());

		NurseEntity nurse = new NurseEntity();
		nurse.setId(ao.getNurseId());

		CareEntity care = new CareEntity();
		care.setId(ao.getCareId());

		context.setAccount(ao.getAccount());
		context.setAddress(ao.getAddress());
		context.setBirthday(ao.getBirthday());
		context.setContact(ao.getContact());
		context.setMale(ao.isMale());
		context.setRole(AccountEntity.ROLE_USER_OLDMAN);
		context.setName(ao.getName());
		context.setStatus(AccountEntity.STATUS_NORMAL);
		context.setIdCard(ao.getIdCard());
		context.setNurse(nurse);
		context.setDoctor(doctor);
		context.setCare(care);
		return context;
	}
	
	@Override
	public QueryResult queryByKey(String key, Integer pageNo, Integer pageSize) throws Exception {
		return super.queryByKey(key, pageNo, pageSize, AccountEntity.ROLE_USER_OLDMAN);
	}

	@Override
	public OldmanContext login(String account, String password) {
		account = $("账号", account);
		password = $("密码", password);
		AccountEntity e = dao.queryByAccount(account);
		if (e == null) {
			throw new ThisSystemException("id.not-exisits", "非法id");
		}
		if (!Objects.equals(password, e.getPassword()))
			throw new ThisSystemException("password.not-same", "密码匹配失败");
		
		OldmanContext context = new OldmanContext();

		context.setAccount(e.getAccount());
		context.setAddress(e.getAddress());
		context.setBirthday(e.getBirthday());
		context.setContact(e.getContact());
		context.setMale(e.isMale());
		context.setRole(e.getRole());
		context.setName(e.getName());
		context.setStatus(e.getStatus());
		context.setIdCard(e.getIdCard());
		return context;
	}
}
