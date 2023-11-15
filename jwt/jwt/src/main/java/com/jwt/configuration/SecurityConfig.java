package com.jwt.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity //it is use for controller @preAuthorize annotaion
public class SecurityConfig {

    @Autowired
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private final AuthenticationProvider authenticationProvider;

//    @Autowired
//    private final PersonDao repository;
//////////Authentication//////////
//    @Bean
//    public UserDetailsService userDetailsService() {

        /////////////its for hard corded//////////
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
//        UserDetails admin = User.withUsername("afham").password(passwordEncoder.encode("kaka786")).roles("ADMIN").build();
//
//        UserDetails user = User.withUsername("kaka").password(passwordEncoder.encode("kaka786")).roles("USER").build();
//
//        return new InMemoryUserDetailsManager(admin,user);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/authentication/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
//                .authorizeHttpRequests().requestMatchers("/person/**")
//                .authenticated()
//                .and()
//                .formLogin();
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }



}
