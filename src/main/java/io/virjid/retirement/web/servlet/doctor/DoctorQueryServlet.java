package io.virjid.retirement.web.servlet.doctor;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.virjid.retirement.ApplicationContextUtil;
import io.virjid.retirement.common.JSONResponseHttpServlet;
import io.virjid.retirement.service.DoctorService;

@WebServlet("/doctor/query")
public class DoctorQueryServlet extends JSONResponseHttpServlet {
	private static final long serialVersionUID = -3246646800795405967L;
	private DoctorService service = ApplicationContextUtil.getBean(DoctorService.class);
	@Override
	protected Object handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String account = req.getParameter("account");
		
		return service.queryByAccount(account);
	}
}
