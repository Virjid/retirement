package io.virjid.retirement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

import io.virjid.retirement.ao.AccountAddAo;
import io.virjid.retirement.common.StringHelper;
import io.virjid.retirement.dao.AccountDao;
import io.virjid.retirement.dto.AccountContext;
import io.virjid.retirement.dto.QueryResult;
import io.virjid.retirement.entity.AccountEntity;
import io.virjid.retirement.exception.ThisSystemException;
import io.virjid.retirement.service.AccountService;

import static io.virjid.retirement.common.validator.ValidateHelper.*;

import java.util.List;
import java.util.Objects;

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
	public AccountEntity insert(AccountAddAo ao) throws Exception {
		//1 验证或清理参数
		//1.1 验证必要参数是否非空
		String account = $("账号", ao.getAccount());
		String address = $("地址", ao.getAddress());
		String contact = $("联系方式", ao.getContact());
		String idCard = $("身份证", ao.getIdCard());
		String password = $("密码", ao.getPassword());
		String passwordConfirm = $("密码确认", ao.getPasswordConfirm());
		String name = $("名字", ao.getName());
		
		//1.2 限制个别参数的长度范围
		assertLength("账号", account, 4, 16);
		assertLength("名字", name, 2, 16);
		assertLength("密码", password, 6, 16);
		
		//1.3 验证参数的格式是否匹配
		assertMatch("账号只能是字母和数字组成的6-16位", account, "[0-9a-zA-Z]{6,16}");
		assertMatch("名字必须是中文2-16位", name, "[\u4e00-\u9fa5·]{2,16}");
		assertAlphanumeric("密码", password);
		
		//2 业务逻辑
		//2.1 验证密码的两次输入是否匹配
		if (!Objects.equals(password, passwordConfirm))
			throw new ThisSystemException("password.not-same", "两次密码不一致");
		
		//2.2 验证账号是否已经被注册了
		if (accountDao.isExistByAccount(account))
			throw new ThisSystemException("acount.exists", "账号已存在");
		
		//2.3 组装实体并插入用户信息
		AccountEntity entity = new AccountEntity();
		entity.setAccount(account);
		entity.setAddress(address);
		entity.setBirthday(ao.getBirthday());
		entity.setContact(contact);
		entity.setId(uuid());
		entity.setIdCard(idCard);
		entity.setRole(ao.getRole());
		entity.setStatus(ao.getStatus());
		entity.setPassword(password);
		entity.setMale(ao.isMale());
		entity.setName(name);
		accountDao.insert(entity);
		
		//3 组装业务结果并返回
		return entity;
	}
	
	@Override
	public QueryResult queryByKey(String key, Integer pageNo, Integer pageSize) throws Exception {
		key=trimAsNull(key);
		if(key!=null) key=key+"%";
		
		if(pageNo==null) pageNo=1;
		
		if(pageSize==null) pageSize=10;
		
		List<AccountEntity> rows = accountDao.selectByKey(key,pageNo,pageSize);
		
		PageInfo<AccountEntity> pageInfo=new PageInfo<>(rows);
		
		int totalRows=(int)pageInfo.getTotal();
		
		QueryResult result=new QueryResult();
		result.setPageNo(pageNo);
		result.setPageSize(pageSize);
		result.setTotalRows(totalRows);
		result.setRows(rows);
		
		return result;
	}
}
