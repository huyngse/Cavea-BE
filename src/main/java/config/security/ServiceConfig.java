package config.security;

import jakarta.*;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class ServiceConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// Enable CORS and disable CSRF
		http = http.cors().and().csrf().disable();

		// Set session management to STATELESS
		http = http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and();

		// Set unauthorized requests exception handler
		http = http
				.exceptionHandling()
				.authenticationEntryPoint((request, response, ex) -> {
					response.sendError(
							HttpServletResponse.SC_UNAUTHORIZED, 
							ex.getMessage()
					);
				})
				.and();

		// Set authorities (role/permissions) on endpoints
        http
        	.authorizeRequests()
            // Our public endpoints
        	.requestMatchers("/").permitAll()
            .requestMatchers("/public/**").permitAll()
            .requestMatchers("/images/**").permitAll()
            .requestMatchers("/auth/**").permitAll()
            // Our private endpoints
            .requestMatchers("/customer/**").hasRole("CUSTOMER") // customer 123456
            .requestMatchers("/staff/**").hasRole("STAFF") // staff 123456
            .requestMatchers("/manager/**").hasRole("MANAGER") // manager 123456
            .anyRequest().authenticated();

		http.httpBasic();
		
		return http.build();
	}

	@Bean
	@Autowired
	public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder,
			UserDetailsService userDetailsService) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class).userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder).and().build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		return new AccountDetailsServiceIml();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder(); // default & no need prefix {bcrypt} in db
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder(); // based on prefix like {bcrypt} to encode
		return encoder;
	}
	
	 // Used by Spring Security if CORS is enabled.
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source =
            new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
