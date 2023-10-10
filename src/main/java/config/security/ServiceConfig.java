package config.security;

import jakarta.*;


import jakarta.servlet.http.HttpServletResponse;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
public class ServiceConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// Enable CORS and disable CSRF
		http = http.csrf(csrf -> csrf.disable());

		// Set session management to STATELESS
		http = http.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		// Set unauthorized requests exception handler
		http = http
                .exceptionHandling(handling -> handling
                        .authenticationEntryPoint((request, response, ex) -> {
                            response.sendError(
                                    HttpServletResponse.SC_UNAUTHORIZED,
                                    ex.getMessage()
                            );
                        }));

		// Set authorities (role/permissions) on endpoints
        http
        	.authorizeHttpRequests()
            // Our public endpoints
        	.requestMatchers("/").permitAll()
            .requestMatchers("/public/**").permitAll()
            .requestMatchers("/images/**").permitAll()
            .requestMatchers("/auth/**").permitAll()
            // Our private endpoints
            .requestMatchers("/auth/**").permitAll()
            .requestMatchers("/account/**").permitAll() // customer 123456
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
        config.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        config.setAllowedMethods(Arrays.asList("GET","POST" ,"PUT", "DELETE", "OPTIONS"));
        config.addAllowedHeader("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
