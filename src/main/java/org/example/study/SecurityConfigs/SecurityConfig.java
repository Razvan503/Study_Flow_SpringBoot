package org.example.study.SecurityConfigs;

import org.example.study.SecurityConfigs.jwt.JwtValidationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.example.study.SecurityConfigs.CustomAuthenticationProvider;
import org.springframework.security.web.authentication.AuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;

    public SecurityConfig(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Autowired
    private JwtValidationFilter jwtValidationFilter;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

       http.addFilterBefore(jwtValidationFilter, AuthenticationFilter.class);
        http.csrf(
                c-> c.disable()
        );

        http.cors(
                c -> c.disable()
        );

        http.authenticationProvider(authenticationProvider);

        http.sessionManagement((session)->session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        http.authorizeHttpRequests(c -> c
                .requestMatchers("/api/register","/api/login").permitAll()
                .requestMatchers("/api/test").hasRole("USER")
        );
        return http.build();

    }
}
