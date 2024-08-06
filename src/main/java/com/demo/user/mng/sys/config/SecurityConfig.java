package com.demo.user.mng.sys.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.demo.user.mng.sys.constants.ApiPathConstants;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private static final String[] AUTH_LIST = { ApiPathConstants.AUTH + "/**", "/api/v1/auth/**", "/v3/api-docs/**",
			"/v3/api-docs.yaml", "/swagger-ui/**", "/swagger-ui.html" };

	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())

				.authorizeHttpRequests(requests -> requests.requestMatchers(ApiPathConstants.USER + "/**")
						.hasRole("USER").requestMatchers(ApiPathConstants.ADMIN + "/**").hasRole("ADMIN")
						.requestMatchers(AUTH_LIST).permitAll().anyRequest().authenticated());
		return http.build();
	}

	@Bean
	ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
