package com.tech.trainings.security.in_memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

//@EnableWebSecurity
public class JDBCAuthenticationConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    /**
     * Authentication config
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource);
    }

    /**
     * Authorization config
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/manager").hasRole("MANAGER")
                .antMatchers("/user").hasAnyRole("USER", "MANAGER")
                .antMatchers("/h2-console/**").permitAll()
                .and().formLogin();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

    /**
     * password encoder to encrypt password
     * @return
     */
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
