package org.example.study.SecurityConfigs.jwt;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class JwtValidationFilter implements Filter {

    @Autowired
    private TokenReader tokenReader;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException{
       var httpRequest = (HttpServletRequest) servletRequest;
       var httpResponse = (HttpServletResponse) servletResponse;

       String uri = httpRequest.getRequestURI();
       if(uri.equals("/.well-known/appspecific/com.chrome.devtools.json")){
            httpResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
       }

       if(uri.equals("/api/register") || uri.equals("/api/login")){
           filterChain.doFilter(servletRequest,servletResponse);
           return;
       }

       String jwt = httpRequest.getHeader("Cookie");
       String token = jwt.substring("jwt=".length()); //takes the actual token
       String username = tokenReader.getUsername(token);
       String role = tokenReader.getRole(token);

       if(username == null || role == null){
           httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
           return;
       }

        String formattedRole = role.toUpperCase();
        if (!formattedRole.startsWith("ROLE_")) {
            formattedRole = "ROLE_" + formattedRole;
        }

       System.out.println("DEBUG: User: " + username + " | Authority: " + formattedRole);
       SimpleGrantedAuthority authority = new SimpleGrantedAuthority(formattedRole);
       UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,null, List.of(authority));
       SecurityContextHolder.getContext().setAuthentication(authenticationToken);
       filterChain.doFilter(servletRequest,servletResponse);

    }
}
