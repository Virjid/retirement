package io.virjid.retirement.web.servlet.account;

import java.time.LocalDate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.virjid.retirement.ApplicationContextUtil;
import io.virjid.retirement.ao.AccountAddAo;
import io.virjid.retirement.common.DateUtil;
import io.virjid.retirement.common.JSONResponseHttpServlet;
import io.virjid.retirement.service.AccountService;

@WebServlet("/account/register")
public class AccountRegisterServlet extends JSONResponseHttpServlet {
	private static final long serialVersionUID = -3228160225365819182L;
	private AccountService service = ApplicationContextUtil.getBean(AccountService.class);

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
		
		Integer role = Integer.valueOf(req.getParameter("role"));
		Integer status = Integer.valueOf(req.getParameter("status"));

		AccountAddAo ao = new AccountAddAo();
		ao.setAccount(account);
		ao.setAddress(address);
		ao.setContact(contact);
		ao.setIdCard(idCard);
		ao.setMale(male);
		ao.setName(name);
		ao.setPassword(password);
		ao.setPasswordConfirm(passwordConfirm);
		ao.setRole(role);
		ao.setStatus(status);
		ao.setBirthday(birthday);
		
		service.insert(ao);
		return ao;
	}
}
