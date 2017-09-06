package com.chen.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan("com.chen.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		 InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		 resolver.setPrefix("/WEB-INF/views/");
		 resolver.setSuffix(".jsp");
		 resolver.setExposeContextBeansAsAttributes(true);

	/*	List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

		InternalResourceViewResolver r1 = new InternalResourceViewResolver();
		r1.setPrefix("/WEB-INF/pages/");
		r1.setSuffix(".jsp");
		r1.setViewClass(JstlView.class);
		resolvers.add(r1);

		JsonViewResolver r2 = new JsonViewResolver();
		resolvers.add(r2);

		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setViewResolvers(resolvers);
		resolver.setContentNegotiationManager(manager);
		resolver.setOrder(1);*/

		return resolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();

	}

}
