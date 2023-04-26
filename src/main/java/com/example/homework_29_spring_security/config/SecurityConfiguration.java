package com.example.homework_29_spring_security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


/*    @Bean
    public SecurityFilterChain getSFC(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(request -> request.anyRequest()
                        .authenticated())
                .formLogin()
                .defaultSuccessUrl("/ping", true)
                .and()
                .logout();
        return httpSecurity.build();
    }*/
/*@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.cors(AbstractHttpConfigurer::disable).authorizeHttpRequests((authz) -> authz
                    .requestMatchers("/ping","/users").permitAll()
                    .requestMatchers("/products", "/users").hasAuthority("ADMIN")
                    .requestMatchers("/orders").hasAuthority("USER")
                    .anyRequest().authenticated())
            .csrf().disable()
            .httpBasic(Customizer.withDefaults());
    return http.build();
}*/
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.disable()).authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/ping").permitAll()
                        .requestMatchers("/products", "/users","/orders").hasRole("ADMIN")
                        .requestMatchers("/products","/orders").hasRole("USER")
                        .anyRequest().authenticated())
                .formLogin()
                .and()
                .logout();
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails user = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("123"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}

