package com.happyrecipek.web.com.system.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mobile.device.DeviceHandlerMethodArgumentResolver;
import org.springframework.mobile.device.DeviceResolverHandlerInterceptor;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Autowired
	private MessageSource messageSource;
	
	
	@Override public void addViewControllers(ViewControllerRegistry registry) {
	  //registry.addViewController("/").setViewName("index");
	  //registry.addViewController("/login").setViewName("/");
	  //registry.addViewController("/home").setViewName("userhome");
	  //registry.addViewController("/admin/home").setViewName("adminhome");
	  //registry.addViewController("/403").setViewName("403"); }
	  } 
 
    @Override
    public Validator getValidator() {
        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
        factory.setValidationMessageSource(messageSource);
        return factory;
    }
 
    @Bean
    public SpringSecurityDialect securityDialect() {
         return new SpringSecurityDialect();
    }
	
    @Bean
    public DeviceResolverHandlerInterceptor deviceResolverHandlerInterceptor() {
    	return new DeviceResolverHandlerInterceptor();
    }
    
    @Bean
    public DeviceHandlerMethodArgumentResolver deviceHandlerMethodArgumentResolver() {
    	return new DeviceHandlerMethodArgumentResolver();
    }

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(deviceResolverHandlerInterceptor());
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(deviceHandlerMethodArgumentResolver());
	}

}
