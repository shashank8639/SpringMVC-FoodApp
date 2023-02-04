package com.hotel.mvc.springmvc_hotelapp.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {  AppConfiguration.class  };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
