package org.example.study.SecurityConfigs;

import org.example.study.SecurityConfigs.jwt.JwtValidationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter; // Use this import
import org.springframework.web.cors.CorsConfiguration; // Import this
import org.springframework.web.cors.CorsConfigurationSource; // Import this
import org.springframework.web.cors.UrlBasedCorsConfigurationSource; // Import this

import java.util.List;

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

        // 1. Enable CORS by linking to the Bean below
        http.cors(c -> c.configurationSource(corsConfigurationSource()));

        // 2. Disable CSRF (Correct)
        http.csrf(c -> c.disable());

        // 3. Add Filter - usually better to place before UsernamePasswordAuthenticationFilter
        http.addFilterBefore(jwtValidationFilter, UsernamePasswordAuthenticationFilter.class);

        http.authenticationProvider(authenticationProvider);

        http.sessionManagement((session)->session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        http.authorizeHttpRequests(c -> c
                // Allow specific endpoints
                .requestMatchers("/api/register", "/api/login").permitAll()
                // Allow Preflight OPTIONS requests (Crucial for Angular)
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // Secured endpoints
                .requestMatchers("/api/test","/api/addCourse","/api/courses","/api/analytics","/api/addCourse","/api/addSession","/api/completeChapter").hasRole("USER")
                .anyRequest().authenticated()
        );
        return http.build();
    }

    // 4. Define the CORS configuration here
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Allow your Angular frontend
        configuration.setAllowedOrigins(List.of("http://localhost:4200"));

        // Allow standard HTTP methods
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Allow headers typically sent by Angular
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type", "X-Requested-With", "Accept"));

        // Allow Credentials (Cookies) - Essential for your JWT implementation
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
