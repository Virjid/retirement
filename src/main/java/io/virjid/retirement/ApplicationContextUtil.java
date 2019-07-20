package io.virjid.retirement;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil {
	private static final ApplicationContext CONTEXT;
	
	static {
		CONTEXT=new ClassPathXmlApplicationContext("classpath:/spring-*.xml");
	}
	
	public static <T> T getBean(Class<T> type) {
		return CONTEXT.getBean(type);
	}
}
