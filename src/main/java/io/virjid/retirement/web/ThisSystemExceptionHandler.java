package io.virjid.retirement.web;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.virjid.retirement.dto.JSONResponse;
import io.virjid.retirement.exception.ThisSystemException;


@RestControllerAdvice
public class ThisSystemExceptionHandler {

	public JSONResponse handleThisSystemException(ThisSystemException e) {
		return JSONResponse.fail(e.getCode(), e.getMessage());
	}

	public JSONResponse handleThrowable(Throwable e) {
		JSONResponse result=new JSONResponse();
		result.setCode("error");
		result.setMessage("系统好累好累");
		return result;
	}
}
