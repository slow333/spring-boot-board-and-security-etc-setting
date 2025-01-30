package com.me.sbb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  CorsConfigurationSource corsConf() {
    return request -> {
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowedHeaders(Collections.singletonList("*"));
      config.setAllowedMethods(Collections.singletonList("*"));
      config.setAllowedOrigins(Arrays.asList("http://localhost:8888","http://127.0.0.1:8888"));
      config.setMaxAge(3600L);
      config.setAllowCredentials(true);

      return config;
    };
  }

  @Bean
  SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
            .httpBasic(HttpBasicConfigurer::disable)
            .cors(corsConfigurer ->
                    corsConfigurer.configurationSource(corsConf()))
            .csrf(AbstractHttpConfigurer::disable)
            .headers(httpSecurityHeadersConfigurer ->
                    httpSecurityHeadersConfigurer
                            .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
            .authorizeHttpRequests(auth -> {
              auth
                      .requestMatchers("/**").permitAll()
                      .requestMatchers("/login").permitAll()
                      .requestMatchers("/h2-console").permitAll()
                      .requestMatchers("/question/**").permitAll()
                      .requestMatchers("/answer/**").permitAll()
                      .requestMatchers("/board/**").permitAll()
                      .requestMatchers("/sbb-UI/**").permitAll()
                      .requestMatchers("/sbbui/**").permitAll()
                      .requestMatchers("/user/**").permitAll();
            });
    return httpSecurity.build();
  }
}
