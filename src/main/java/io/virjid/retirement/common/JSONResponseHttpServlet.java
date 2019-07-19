package io.virjid.retirement.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import io.virjid.retirement.dto.JSONResponse;
import io.virjid.retirement.exception.ThisSystemException;

public abstract class JSONResponseHttpServlet extends HttpServlet {
	private static final long serialVersionUID = -5394930913949251287L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1、获取参数
		req.setCharacterEncoding("utf-8");
		JSONResponse result=new JSONResponse();
		// 2、执行业务模型，获取业务结果
		try {
			Object data=this.handleRequest(req, resp);
			result.setCode("ok");
			result.setData(data);
		} catch (ThisSystemException e) {
			result.setCode(e.getCode());
			result.setMessage(e.getMessage());
		} catch (Throwable e) {
			e.printStackTrace();
			// 2.2 失败
			result.setCode("error");
			result.setMessage("系统好忙好忙");
		}
		// 3、把业务结果转换为json字符串输出
		resp.setContentType("application/json;charset=utf-8");
		try (PrintWriter out = resp.getWriter()) {
			String json = JSON.toJSONString(result);
			out.write(json);
		}
	}
	
	protected abstract Object handleRequest(HttpServletRequest req, HttpServletResponse resp)throws Exception;
}
