package io.virjid.retirement.web.servlet.account;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.virjid.retirement.ApplicationContextUtil;
import io.virjid.retirement.common.JSONResponseHttpServlet;
import io.virjid.retirement.dto.AccountContext;
import io.virjid.retirement.service.AccountService;

@WebServlet("/account/query")
public class AccountQueryServlet extends JSONResponseHttpServlet {
	private static final long serialVersionUID = -4224759718344512674L;
	private AccountService service = ApplicationContextUtil.getBean(AccountService.class);

	@Override
	protected Object handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String account = req.getParameter("account");
		
		AccountContext data = service.queryByAccount(account);
		return data;
	}
	
}
