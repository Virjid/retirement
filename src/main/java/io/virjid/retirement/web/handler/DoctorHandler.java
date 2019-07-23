package io.virjid.retirement.web.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.virjid.retirement.ao.AccountAddAo;
import io.virjid.retirement.dto.DoctorContext;
import io.virjid.retirement.dto.JSONResponse;
import io.virjid.retirement.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorHandler {
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping("/query")
	public JSONResponse queryDoctor(String account) throws Exception {
		DoctorContext context = doctorService.queryByAccount(account);
		return JSONResponse.ok(context);
	}
	
	@RequestMapping("/register")
	public JSONResponse register(AccountAddAo ao) throws Exception {
		DoctorContext context = doctorService.insert(ao);
		return JSONResponse.ok(context);
	}
}
