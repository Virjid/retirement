package io.virjid.retirement.web.servlet.oldman;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.virjid.retirement.ApplicationContextUtil;
import io.virjid.retirement.common.JSONResponseHttpServlet;
import io.virjid.retirement.dto.QueryResult;
import io.virjid.retirement.service.OldmanService;

@WebServlet("/oldman/query")
public class OldmanQueryServlet extends JSONResponseHttpServlet {
	private static final long serialVersionUID = 2516268840577224050L;
	private OldmanService service = ApplicationContextUtil.getBean(OldmanService.class);

	@Override
	protected Object handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String key = req.getParameter("key");
		Integer no = Integer.valueOf(req.getParameter("no"));
		Integer size = Integer.valueOf(req.getParameter("size"));
		
		QueryResult data = service.queryByKey(key, no, size);
		return data;
	}
}
