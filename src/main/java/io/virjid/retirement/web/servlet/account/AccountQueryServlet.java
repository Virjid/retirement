package io.virjid.retirement.web.servlet.account;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.virjid.retirement.ApplicationContextUtil;
import io.virjid.retirement.common.JSONResponseHttpServlet;
import io.virjid.retirement.dto.QueryResult;
import io.virjid.retirement.service.AccountService;

@WebServlet("/account/query")
public class AccountQueryServlet extends JSONResponseHttpServlet {
	private static final long serialVersionUID = -4224759718344512674L;
	private AccountService service = ApplicationContextUtil.getBean(AccountService.class);

	@Override
	protected Object handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String account = req.getParameter("account");
		Integer no = Integer.valueOf(req.getParameter("no"));
		Integer size = Integer.valueOf(req.getParameter("size"));
		
		QueryResult data = service.queryByKey(account, no, size);
		return data;
	}
	
}
