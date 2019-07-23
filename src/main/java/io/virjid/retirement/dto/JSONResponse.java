package io.virjid.retirement.dto;

public class JSONResponse {
	private String code;
	private String message;
	private Object data;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public static JSONResponse ok(Object data) {
		JSONResponse response=new JSONResponse();
		response.setCode("ok");
		response.setData(data);
		return response;
	}
	public static JSONResponse ok() {
		return ok(null);
	}
	
	public static JSONResponse fail(String code,String message) {
		JSONResponse response=new JSONResponse();
		response.setCode(code);
		response.setMessage(message);
		return response;
	}
	public static JSONResponse fail(String message) {
		return fail("error",message);
	}
	
}
