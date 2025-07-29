package com.example.demo.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.entity.UserRole;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Component
public class TokenService {

    private static final String BEARER_PREFIX = "Bearer ";

//    @Value("${jwt.secret}")
//    private String secret;

    public String createToken(Long userId, UserRole role) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("asdsadsadsadsadsadasdas");
            String token = JWT.create()
                    .withIssuer("auth0")
                    .withSubject(Long.toString(userId))
                    .withClaim("role", role.name())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            // Invalid Signing configuration / Couldn't convert Claims.
            throw new RuntimeException("생성실패", exception);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

/*
    public long verifyToken(String bearerToken) {
*/
    public DecodedJWT verifyToken(String bearerToken) {

        try {
            Algorithm algorithm = Algorithm.HMAC256("asdsadsadsadsadsadasdas");

            String token = bearerToken.substring((BEARER_PREFIX.length()));
            JWTVerifier verifier = JWT.require(algorithm)
                    // specify any specific claim validations
                    .withIssuer("auth0")
                    // reusable verifier instance
                    .build();

            DecodedJWT decodedJWT = verifier.verify(token);
           /* String userId = decodedJWT.getSubject();

            return Long.parseLong((userId));*/
            return decodedJWT;

        } catch (JWTVerificationException exception) {
            throw new RuntimeException("검증실패", exception);
            // Invalid signature/claims
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("HMAC256에 맞지않음",e);
        }
    }
}





