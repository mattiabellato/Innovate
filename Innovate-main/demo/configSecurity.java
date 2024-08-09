package com.example.demo;


	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.security.config.annotation.web.builders.HttpSecurity;
	import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
	import org.springframework.security.core.userdetails.User;
	import org.springframework.security.core.userdetails.UserDetails;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.provisioning.InMemoryUserDetailsManager;
	import org.springframework.security.web.SecurityFilterChain;
	import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
	import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
	import org.springframework.security.crypto.password.PasswordEncoder;


	@Configuration
	@EnableWebSecurity
	public class configSecurity {

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests(authorizeRequests -> 
	                authorizeRequests
	                
	                .requestMatchers("/private/gestore").authenticated()
	                   
	                
	                .requestMatchers("/**").permitAll() // Consenti a tutti di accedere all'endpoint "/"
	                  
	                
	                
	                .requestMatchers("show").permitAll()
	                    
	                    .anyRequest().authenticated()
	                    
	            )
	            
	            .csrf(csrf -> csrf
	                    .disable()  // Disabilita CSRF se strettamente necessario
	                )
	            .formLogin(formLogin ->
	                formLogin
	                    .loginPage("/login")
	                    .permitAll()
	            )
	            .logout(logout -> 
	                logout.permitAll()
	            );
	        return http.build();
	    }

	    
	    
	    @Bean
	    public UserDetailsService userDetailsService() {
	        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	        manager.createUser(User.withUsername("avengers")
	            .password(passwordEncoder().encode("888"))
	            .roles("USER").build());
	        return manager;
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Bean
	    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
	        return (request, response, authentication) -> {
	            response.sendRedirect("/private/gestore");
	        };
	    
	}}
