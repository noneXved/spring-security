package com.github.nonexved.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(3)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/secured/**", "/api/secured/**")
            .hasRole("USER")
            .and()
            .formLogin()
            .and()
            .httpBasic()
            .and()
            .oauth2Login();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser("user1")
            .password("{bcrypt}$2a$06$Hwx3rOkXLPnTivEIO3kqSe9j1jnjFeNKzv4Zthi5OHBFR9KtVFqwe")
            .roles("USER")
            .and()
            .withUser("user2")
            .password("{bcrypt}$2a$06$Hwx3rOkXLPnTivEIO3kqSe9j1jnjFeNKzv4Zthi5OHBFR9KtVFqwe")
            .roles("TEST");
    }
}
