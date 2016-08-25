package com.mljr.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mljr.demo.util.SpringBeanUtil;

@Component
public class AppInitListener implements ServletContextInitializer {
	private static Logger LOG = Logger.getLogger(AppInitListener.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		try {
			LOG.info("AppInitializeListener Initializing....");
			ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
			SpringBeanUtil.setContext(applicationContext);
		} catch (Exception e) {
			LOG.error("AppInitializeListener Initializing fail", e);
		}

	}

}
