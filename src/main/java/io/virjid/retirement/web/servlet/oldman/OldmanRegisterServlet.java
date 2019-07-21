package io.virjid.retirement.web.servlet.oldman;

import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.virjid.retirement.ApplicationContextUtil;
import io.virjid.retirement.ao.OldmanAddAo;
import io.virjid.retirement.common.DateUtil;
import io.virjid.retirement.common.JSONResponseHttpServlet;
import io.virjid.retirement.dto.OldmanContext;
import io.virjid.retirement.entity.AccountEntity;
import io.virjid.retirement.entity.CareEntity;
import io.virjid.retirement.entity.DoctorEntity;
import io.virjid.retirement.entity.NurseEntity;
import io.virjid.retirement.service.OldmanService;

@WebServlet("/oldman/register")
public class OldmanRegisterServlet extends JSONResponseHttpServlet {
	private static final long serialVersionUID = -1121737562951506030L;
	private OldmanService service = ApplicationContextUtil.getBean(OldmanService.class);

	@Override
	protected Object handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String account = req.getParameter("account");
		String idCard = req.getParameter("idCard");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String passwordConfirm = req.getParameter("passwordConfirm");
		
		LocalDate birthday = DateUtil.localDateParse(req.getParameter("birthday"));
		Boolean male = req.getParameter("male").equals("1");
		String address = req.getParameter("address");
		String contact = req.getParameter("contact");
		
		String doctorId = req.getParameter("doctorId");
		String nurseId = req.getParameter("nurseId");
		String careId = req.getParameter("careId");

		OldmanAddAo ao = new OldmanAddAo();
		ao.setAccount(account);
		ao.setAddress(address);
		ao.setContact(contact);
		ao.setIdCard(idCard);
		ao.setMale(male);
		ao.setName(name);
		ao.setPassword(password);
		ao.setPasswordConfirm(passwordConfirm);
		ao.setRole(AccountEntity.ROLE_USER_OLDMAN);
		ao.setStatus(AccountEntity.STATUS_NORMAL);
		ao.setBirthday(birthday);
		ao.setNurseId(nurseId);
		ao.setDoctorId(doctorId);
		ao.setCareId(careId);
		
		
		service.insert(ao);
		
		DoctorEntity doctor = new DoctorEntity();
		doctor.setId(doctorId);
		
		NurseEntity nurse = new NurseEntity();
		nurse.setId(nurseId);
		
		CareEntity care = new CareEntity();
		care.setId(careId);
		
		OldmanContext act = new OldmanContext();
		
		act.setAccount(account);
		act.setAddress(address);
		act.setBirthday(birthday);
		act.setContact(contact);
		act.setMale(male);
		act.setRole(AccountEntity.ROLE_USER_OLDMAN);
		act.setName(name);
		act.setStatus(AccountEntity.STATUS_NORMAL);
		act.setIdCard(idCard);
		act.setNurse(nurse);
		act.setDoctor(doctor);
		act.setCare(care);
		
		return act;
	}
}
