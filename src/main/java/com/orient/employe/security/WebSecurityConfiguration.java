package com.orient.employe.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());

        return provider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/department/get")
                .hasAuthority("ADMIN")
                .antMatchers("/department/delete/{id}")
                .hasAuthority("ADMIN")
                .antMatchers("/department/update")
                .hasAuthority("ADMIN")
                .antMatchers("/department/create")
                .hasAuthority("ADMIN")
                .antMatchers("/department/get/{id}")
                .hasAuthority("ADMIN")
                .antMatchers("/employe")
                .hasAnyAuthority("ADMIN","USER")
                .antMatchers("/employe/get")
                .hasAnyAuthority("ADMIN")
                .antMatchers("/employe/get/{id}")
                .hasAnyAuthority("ADMIN","USER")
                .antMatchers("/employe/create/{depName}")
                .hasAuthority("ADMIN")
                .antMatchers("/employe/update/{id}/{newDepName}")
                .hasAuthority("ADMIN")
                .antMatchers("/employe/delete/{id}")
                .hasAuthority("ADMIN")
                .and()
                .httpBasic();
    }
}
