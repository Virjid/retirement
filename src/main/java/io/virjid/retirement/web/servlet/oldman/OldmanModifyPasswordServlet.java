package io.virjid.retirement.web.servlet.oldman;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.virjid.retirement.RetirementApplication;
import io.virjid.retirement.ao.AccountModPasswordAo;
import io.virjid.retirement.common.JSONResponseHttpServlet;
import io.virjid.retirement.service.OldmanService;

//@WebServlet("/oldman/modpassword")
public class OldmanModifyPasswordServlet extends JSONResponseHttpServlet {
	private static final long serialVersionUID = -3519445250508024141L;
//	private OldmanService service = RetirementApplication.getBean(OldmanService.class);

	@Override
	protected Object handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String id = req.getParameter("id");
		String account = req.getParameter("account");
		String newPassword = req.getParameter("newPassword");
		String oldPassword = req.getParameter("oldPassword");
		String newPasswordConfirm = req.getParameter("newPasswordConfirm");
		
		AccountModPasswordAo ao = new AccountModPasswordAo();
		ao.setAccount(account);
		ao.setId(id);
		ao.setNewPassword(newPassword);
		ao.setNewPasswordConfirm(newPasswordConfirm);
		ao.setOldPassword(oldPassword);
		
//		service.modifyPassword(ao);
		return null;
	}

}
