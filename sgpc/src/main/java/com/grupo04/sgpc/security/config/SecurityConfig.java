/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo04.sgpc.security.config;

import com.grupo04.sgpc.service.controller.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author rafael-d
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private LoginService service;
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/css/**","/js/**","/img/**" ).permitAll()
                
                //.antMatchers("/").permitAll() //tava comentado
                
                //Acessos Administrador
                .antMatchers("/").hasAnyAuthority("SA","OP","ADM")
                
                //Acessos Frentistas
                .antMatchers("/pistas/**").hasAnyAuthority("SA","OP","GER")
              
                //Acessos Balconistas
                .antMatchers("/lojas/**").hasAnyAuthority("SA","OP","GER")
                
                //Acessos Caixas
                
                //Acessos Administrativos
                .antMatchers("/cadastros/**").hasAnyAuthority("SA","ADM","GER")

                
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/main", true)
                    .failureUrl("/login-error")
                    .permitAll()
                .and()
                    .logout()
                    .logoutSuccessUrl("/");
        
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
    }
    
    
    
    
    
}
