package com.tm.s2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
/*
	@Bean
	public UserDetailsService userDetailsService() {
		return null;
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
*/
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll()
			.antMatchers("/chat/**").hasAuthority("Admin")
			.anyRequest().authenticated()
			.and().formLogin()
			//.loginPage("/login")
			//.usernameParameter("username")
			.permitAll()
			.and()
			.rememberMe().key("1234")
			.and()
			.logout().permitAll();

		http.headers().frameOptions().sameOrigin();
		return http.build(); //
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
	}
}
