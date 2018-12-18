package com.citibank.ohs.web.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.citibank.ohs.web.config.DispatcherConfig;
import com.citibank.ohs.web.config.RootConfig;

public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext rootCtx,dsCtx=null;
		
		rootCtx=new AnnotationConfigWebApplicationContext();
		rootCtx.register(RootConfig.class);
		
		dsCtx=new AnnotationConfigWebApplicationContext();
		dsCtx.register(DispatcherConfig.class);
		
		//create ContextLoaderListner
		ContextLoaderListener listner=new ContextLoaderListener(rootCtx);
		servletContext.addListener(listner);
		
		//create DispatcherServlet
		DispatcherServlet dispatcherServlet=new DispatcherServlet(dsCtx);
		ServletRegistration.Dynamic register=servletContext.addServlet("dispatcher",dispatcherServlet);
		register.setLoadOnStartup(2);
		register.addMapping("/");

	}
}