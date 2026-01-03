package org.example.study.Controllers;

import org.example.study.SecurityConfigs.CustomUserDetailService;
import org.example.study.SecurityConfigs.jwt.TokenCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.study.Models.Login.LoginRequest;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class Login {

    @Autowired
   private TokenCreator tokenCreator;

   @Autowired
   private AuthenticationManager authenticationManager;

   @Autowired
   private CustomUserDetailService userDetailService;

   @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequest login){
       String username = login.getUsername();
       String password = login.getPassword();


       Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

       SecurityContextHolder.getContext().setAuthentication(authentication);
       Authentication authenticated = SecurityContextHolder.getContext().getAuthentication();

        String role;
        GrantedAuthority authority = authentication.getAuthorities().iterator().next();
        role = authority.getAuthority();


        String token = tokenCreator.createToken(username,role);
        HttpHeaders headers = new HttpHeaders();
        ResponseCookie cookie = ResponseCookie.from("jwt",token)
               .httpOnly(true)
               .secure(false)
               .path("/")
               .sameSite("Strict")
               .build();

        headers.add(HttpHeaders.SET_COOKIE,cookie.toString());

        return new ResponseEntity<>(headers, HttpStatus.OK);
   }
}
