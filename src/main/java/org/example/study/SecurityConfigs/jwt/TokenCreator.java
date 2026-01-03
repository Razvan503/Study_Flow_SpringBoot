package org.example.study.SecurityConfigs.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenCreator {

    public  String createToken(String username,String role){
        String secretkey = "secretkey123";
        Algorithm algorithm = Algorithm.HMAC256(secretkey);

        String token = JWT.create()
                .withIssuer("studyflow")
                .withSubject(username)
                .withClaim("role",role)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 36000000 + 100000000))
                .sign(algorithm);
        return token;
    }
}
