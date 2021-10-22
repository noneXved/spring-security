package com.github.nonexved.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.www.DigestAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.DigestAuthenticationFilter;

@Configuration
@Order(1)
public class AdminSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/secured/admin/**", "/api/secured/admin/**")
                .and()
                .addFilter(getDigestAuthenticationFilter())
                .exceptionHandling()
                .authenticationEntryPoint(getDigestAuthenticationEntryPoint())
                .and()
                .authorizeRequests()
                .anyRequest()
                .hasRole("ADMIN");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("admin1").password("admin1").roles("ADMIN")
                .and()
                .withUser("admin2").password("admin2").roles("ADMIN");
    }

    private DigestAuthenticationFilter getDigestAuthenticationFilter() {
        DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
        digestAuthenticationFilter.setUserDetailsService(userDetailsService());
        digestAuthenticationFilter.setAuthenticationEntryPoint(getDigestAuthenticationEntryPoint());
        digestAuthenticationFilter.setCreateAuthenticatedToken(true);

        return digestAuthenticationFilter;
    }

    private DigestAuthenticationEntryPoint getDigestAuthenticationEntryPoint() {
        DigestAuthenticationEntryPoint digestAuthenticationEntryPoint = new DigestAuthenticationEntryPoint();
        digestAuthenticationEntryPoint.setRealmName("admin-product-service");
        digestAuthenticationEntryPoint.setKey("1234abcd1234");

        return digestAuthenticationEntryPoint;
    }
}
