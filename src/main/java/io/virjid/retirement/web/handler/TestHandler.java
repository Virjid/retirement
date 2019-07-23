package io.virjid.retirement.web.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestHandler {
	@ResponseBody
	@PostMapping("/hello")
	public Map<String,String> hello() {
		Map<String,String> map = new HashMap<>(8,1);
		map.put("message", "hello world~");
		return map;
	}
}
