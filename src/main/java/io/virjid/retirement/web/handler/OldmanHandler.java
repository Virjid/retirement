package io.virjid.retirement.web.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.virjid.retirement.ao.OldmanAddAo;
import io.virjid.retirement.ao.OldmanModAo;
import io.virjid.retirement.common.DateUtil;
import io.virjid.retirement.dto.JSONResponse;
import io.virjid.retirement.dto.OldmanContext;
import io.virjid.retirement.dto.QueryResult;
import io.virjid.retirement.entity.AccountEntity;
import io.virjid.retirement.service.OldmanService;

@RestController
@RequestMapping("/oldman")
public class OldmanHandler {
	@Autowired
	private OldmanService oldmanService;

	@GetMapping("/list")
	public JSONResponse listOldman(String key, Integer no, Integer size) throws Exception {
		QueryResult data = oldmanService.queryByKey(key, no, size);
		return JSONResponse.ok(data);
	}

	@PostMapping("/del")
	public JSONResponse deleteOldman(String id) throws Exception {
		oldmanService.delete(id);
		return JSONResponse.ok();
	}

	@PostMapping("/register")
	public JSONResponse registerOldman(OldmanAddAo ao) throws Exception {
		ao.setRole(AccountEntity.ROLE_USER_OLDMAN);
		ao.setStatus(AccountEntity.STATUS_NORMAL);

		OldmanContext context = oldmanService.insert(ao);
		return JSONResponse.ok(context);
	}
	
	@PostMapping("/mod")
	public JSONResponse modifyOldman(String id, OldmanModAo ao) throws Exception {
		Map<String,String> map=new HashMap<String, String>();
		map.put("id", id);
		map.put("name", ao.getName());
		map.put("address", ao.getAddress());
		map.put("idCard", ao.getIdCard());
		map.put("contact", ao.getContact());
		map.put("birthday", DateUtil.localDateToString(ao.getBirthday()));
		
		oldmanService.modifyAccount(id, map);
		return JSONResponse.ok();
	}
	
	@PostMapping("/login")
	public JSONResponse login(String account, String password) {
		System.out.println(account);
		OldmanContext context = oldmanService.login(account, password);
		return JSONResponse.ok(context);
	}
}
