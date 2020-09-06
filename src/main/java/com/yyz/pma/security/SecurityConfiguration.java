package com.yyz.pma.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("myuser")
		.password("pass")
		.roles("USER");
//		auth.jdbcAuthentication()
//			.usersByUsernameQuery("select username, password, enabled "+
//				"from user_accounts where username = ?" )
//			.authoritiesByUsernameQuery("select username, role "+
//				"from user_accounts where username = ?")
//			.dataSource(dataSource)
//			.passwordEncoder(bCryptEncoder);
		
	}
}
