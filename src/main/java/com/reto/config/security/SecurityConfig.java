package com.reto.config.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests(a -> a.antMatchers("/","/error", "/webjars/**", "/api/**", "/images/**")
                .permitAll()
                .anyRequest()
                .authenticated())
                .exceptionHandling(e -> e
                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                ).oauth2Login().defaultSuccessUrl("/index.html", true);

        //para evitar problemas con mastertech a la hora de evaluar los endpoints
        http.cors().and().csrf().disable();
    }
}
