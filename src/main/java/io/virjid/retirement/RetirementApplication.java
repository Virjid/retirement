package io.virjid.retirement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class RetirementApplication implements WebApplicationInitializer {
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();

		appContext.setConfigLocation("classpath:/spring-*.xml");
		// 创建前端控制器
		ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher",
				new DispatcherServlet(appContext));
		registration.setLoadOnStartup(1);
		registration.addMapping("/");
	}
}
