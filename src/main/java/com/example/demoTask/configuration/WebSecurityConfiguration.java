package com.example.demoTask.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class WebSecurityConfiguration{

  @Bean
  public void configure(HttpSecurity http) throws Exception {
//    http.csrf().disable().authorizeRequests()
//        .antMatchers("/").permitAll()
//        .antMatchers(HttpMethod.POST,"/tasks").permitAll()
//        .antMatchers(HttpMethod.GET,"/tasks").permitAll()
//        .antMatchers(HttpMethod.PUT,"/tasks").permitAll()
//        .antMatchers(HttpMethod.DELETE,"/tasks").permitAll()
//        .anyRequest().authenticated();

    http.authorizeHttpRequests()
        .requestMatchers("/tasks/**").permitAll()
        .anyRequest().authenticated();
  }
}
