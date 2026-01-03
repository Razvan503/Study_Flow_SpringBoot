package org.example.study.SecurityConfigs.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class TokenReader {

    public void readToken(String token){
        try{

            String secretkey = "secretkey123";
            Algorithm algorithm = Algorithm.HMAC256(secretkey);

            JWTVerifier verifier = JWT.require(algorithm).withIssuer("studyflow").build();

            DecodedJWT decodedJWT = verifier.verify(token);

            String username = decodedJWT.getSubject();
            String role = decodedJWT.getClaim("role").asString();
            System.out.println(username+role);
        }catch (JWTVerificationException exception){
            System.out.println("Token is invalid " + exception.getMessage());
        }
    }

    public String getUsername(String token){
       try{
           String secretkey = "secretkey123";
           Algorithm algorithm = Algorithm.HMAC256(secretkey);

           JWTVerifier verifier = JWT.require(algorithm).withIssuer("studyflow").build();

           DecodedJWT decodedJWT = verifier.verify(token);

           String username = decodedJWT.getSubject();
           return username;

       }catch (JWTVerificationException exception){
           System.out.println("Token is invalid " + exception.getMessage());
           return null;
       }
    }

    public String getRole(String token){
        try{
            String secretkey = "secretkey123";
            Algorithm algorithm = Algorithm.HMAC256(secretkey);

            JWTVerifier verifier = JWT.require(algorithm).withIssuer("studyflow").build();

            DecodedJWT decodedJWT = verifier.verify(token);

            String role = decodedJWT.getClaim("role").asString();
            return role;
        }catch(JWTVerificationException exception){
            System.out.println("Token is invalid " + exception.getMessage());
            return null;
        }
    }
}
