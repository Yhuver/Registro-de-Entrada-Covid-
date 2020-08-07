package com.ufps.edu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ufps.edu.sevice.LoginUserImpl;


@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoginUserImpl loginUser;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(loginUser).passwordEncoder(encoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				// URLs matching for access rights
				.antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/ufps").permitAll()
				.antMatchers("/simon").permitAll()
				.antMatchers("/home").hasAnyAuthority("Administrador","Usuario")
				.antMatchers("/home/**").hasAnyAuthority("Administrador","Usuario")
				.anyRequest().authenticated()
				.and()
				// form login
				.csrf().disable().formLogin()
				.loginPage("/login")
				.failureUrl("/login?error=true")
				.defaultSuccessUrl("/home")
				.usernameParameter("username")
				.passwordParameter("password")
				.and()
				// logout
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/*");
	}
	
}

