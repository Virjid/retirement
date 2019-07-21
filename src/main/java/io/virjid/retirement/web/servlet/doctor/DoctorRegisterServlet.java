package io.virjid.retirement.web.servlet.doctor;

import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.virjid.retirement.ApplicationContextUtil;
import io.virjid.retirement.ao.AccountAddAo;
import io.virjid.retirement.common.DateUtil;
import io.virjid.retirement.common.JSONResponseHttpServlet;
import io.virjid.retirement.dto.DoctorContext;
import io.virjid.retirement.entity.AccountEntity;
import io.virjid.retirement.service.DoctorService;

@WebServlet("/doctor/register")
public class DoctorRegisterServlet extends JSONResponseHttpServlet {
	private static final long serialVersionUID = 4058654546620263769L;
	private DoctorService service = ApplicationContextUtil.getBean(DoctorService.class);

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

		AccountAddAo ao = new AccountAddAo();
		ao.setAccount(account);
		ao.setAddress(address);
		ao.setContact(contact);
		ao.setIdCard(idCard);
		ao.setMale(male);
		ao.setName(name);
		ao.setPassword(password);
		ao.setPasswordConfirm(passwordConfirm);
		ao.setRole(AccountEntity.ROLE_STAFF_DOCTOR);
		ao.setStatus(AccountEntity.STATUS_NORMAL);
		ao.setBirthday(birthday);
		
		service.insert(ao);
		
		DoctorContext act = new DoctorContext();
		
		act.setAccount(account);
		act.setAddress(address);
		act.setBirthday(birthday);
		act.setContact(contact);
		act.setMale(male);
		act.setRole(AccountEntity.ROLE_STAFF_DOCTOR);
		act.setName(name);
		act.setStatus(AccountEntity.STATUS_NORMAL);
		act.setIdCard(idCard);
		
		return act;
	}
}
