package com.ebru.utils;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class JwtTokenManager {
   /*
    String secretKey = "123";
    String issuer = "abc";
    Long exDate = 1000L*60*5; // 5 min
    */
    @Value("${auth-service.secret.key}")
    String secretKey;
    @Value("${auth-service.issuer}")
    String issuer;
    @Value("${auth-service.expire.date}")
    Long exDate; // 5 min

    // 1- generate Token
    public Optional<String> generateToken(Long id){
        String token = "";
        try {
            token = JWT.create().withAudience()
                    .withClaim("id", id)
                    .withClaim("projectName","AuthService")
                    .withClaim("lastJoin", System.currentTimeMillis())
                    .withIssuer(issuer) // the structure that forms the jwt token
                    .withIssuedAt(new Date()) // jwt creation time
                    .withExpiresAt(new Date(System.currentTimeMillis() + exDate))
                    .sign(Algorithm.HMAC512(secretKey));
            return Optional.of(token);
        }catch (Exception e){
            return Optional.empty();
        }
    }
    // 2- verify Token
    public Boolean verifyToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(issuer).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            if(decodedJWT == null)
                return  false;
        }catch (Exception e){
            return false;
        }
        return true;
    }
    // 3- decode Id information in the token
    public Optional<Long> decodeIdFromToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC512(secretKey);
            JWTVerifier verifier = JWT.require(algorithm).withIssuer(issuer).build();
            DecodedJWT decodedJWT = verifier.verify(token);
            if(decodedJWT == null)
                return  Optional.empty();

            Long id = decodedJWT.getClaim("id").asLong();
            System.out.println("Token_ID: "  +  id);

            String serviceName = decodedJWT.getClaim("serviceName").asString();
            System.out.println("Token_SERVICENAME "  +  serviceName);

            return Optional.of(id);

        }catch (Exception e){
            return Optional.empty();
        }
    }
}
