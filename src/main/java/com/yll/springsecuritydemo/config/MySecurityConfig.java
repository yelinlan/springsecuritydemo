package com.yll.springsecuritydemo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//定制请求的授权规则
		http.authorizeRequests().antMatchers("/").permitAll()
				.antMatchers("/level1/**").hasRole("VIP1")
				.antMatchers("/level2/**").hasRole("VIP2")
				.antMatchers("/level3/**").hasRole("VIP3");
		http.logout().logoutSuccessUrl("/");
		http.formLogin().usernameParameter("user").passwordParameter("pwd").loginPage("/userlogin");
		http.rememberMe().rememberMeParameter("remember");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		//    .passwordEncoder(new BCryptPasswordEncoder())
		auth.inMemoryAuthentication()
				.withUser("level1").password("{noop}123").roles("VIP1", "VIP2").and()
				.withUser("level2").password("{noop}123").roles("VIP2", "VIP3").and()
				.withUser("level3").password("{noop}123").roles("VIP1", "VIP3");
	}
}