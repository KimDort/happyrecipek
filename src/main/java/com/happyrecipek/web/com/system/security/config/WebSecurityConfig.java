package com.happyrecipek.web.com.system.security.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CompositeFilter;

import com.happyrecipek.web.com.member.service.impl.CustomUserDetailService;
import com.happyrecipek.web.com.system.security.classes.ClientResources;

@Configuration
@EnableWebSecurity
@EnableOAuth2Client
@EnableGlobalMethodSecurity(securedEnabled=true,proxyTargetClass=true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@Autowired
	OAuth2ClientContext oauth2ClientContext;
	
	@Autowired
	private DataSource dataSource;

	/**
	 * <pre>
	 * @author KYJ
	 * @since 2019-01-12
	 * Commond
	 * 	User Password Encoder
	 * </pre>
	 * */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@ConfigurationProperties("google")
	public ClientResources google() {
		return new ClientResources();
	}
	
	@Bean
	public FilterRegistrationBean oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter);
        registration.setOrder(-100);
        return registration;
    }
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
		auth
			.userDetailsService(customUserDetailService)
			.passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http)throws Exception{
		http
			.headers()
			.frameOptions().sameOrigin()
			.and()
				.authorizeRequests()
					.antMatchers("/resources/**", "/webjars/**", "/assets/**", "/templates/**", "/com/**", "/ckeditor/**").permitAll()
					.antMatchers("/").permitAll()
					.antMatchers("/cooking/**").permitAll()
					.antMatchers("/introduce/**").permitAll()
					.antMatchers("/admin/**/**").permitAll()
					.antMatchers("/ckeditor/imageUpload").permitAll()
					//.antMatchers("/introduce/write").hasRole("ADMIN")
					//.antMatchers("/introduce/write").permitAll()
					.anyRequest().authenticated()
					.and()
					.exceptionHandling()
					.accessDeniedPage("/")
					.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/"))
					.and()
					.addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class)
				.formLogin()
					.loginPage("/")
					.defaultSuccessUrl("/")
					.failureUrl("/")
					.permitAll()
					.and()
				.logout()
					.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/")
					.invalidateHttpSession(true)
					.permitAll()
					.and()
				.exceptionHandling()
				.and()
				.csrf().disable();
	}
	
	PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
		tokenRepositoryImpl.setDataSource(dataSource);
		return tokenRepositoryImpl;
	}
	
	private Filter ssoFilter() {
		CompositeFilter filter = new CompositeFilter();
		List<Filter> filters = new ArrayList<>();
        filters.add(ssoFilter(google(), "/login/google")); //  이전에 등록했던 OAuth 리다이렉트 URL 
        //filters.add(ssoFilter(facebook(), "/login/facebook"));
        filter.setFilters(filters);
		
		return filter;
	}
	
	private Filter ssoFilter(ClientResources client, String path) {
        OAuth2ClientAuthenticationProcessingFilter filter = new OAuth2ClientAuthenticationProcessingFilter(path);
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(client.getClient(), oauth2ClientContext);
        filter.setRestTemplate(restTemplate);
        UserInfoTokenServices tokenServices = new UserInfoTokenServices(client.getResource().getUserInfoUri(), client.getClient().getClientId());
        tokenServices.setRestTemplate(restTemplate);
        filter.setTokenServices(tokenServices);
        return filter;
    }
}
