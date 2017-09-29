package com.chen.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[]{"/"};
	}
	
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.addListener(ContextLoaderListener.class);
		super.onStartup(servletContext);
	}
}
