package com.example.demoTask.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class WebSecurityConfiguration{
  public void configure(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests()
        .requestMatchers("/tasks/**").permitAll()
        .anyRequest().authenticated();
  }
}
