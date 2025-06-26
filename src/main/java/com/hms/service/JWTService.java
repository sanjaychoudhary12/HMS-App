package com.hms.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {

    @Value("${jwt.algorithm.key}")
    private String algorithmkey;

    @Value("${jwt.issuer}")
    private  String issuer;


    @Value("${jwt.expiry.duration}")
    private int expiryTime;


    private Algorithm algorithm;
// Add a JWTVerifier field
   // private JWTVerifier verifier;

    @PostConstruct
    public  void PostConstruct(){

        algorithm  = Algorithm.HMAC256(algorithmkey);


        // Initialize the verifier
//         verifier = JWT.require(algorithm)
//                      .withIssuer(issuer)
//                      .build();
    }

    public String generateToken(String username) {
        return JWT.create()
                .withClaim("name",username)
                .withExpiresAt(new Date(System.currentTimeMillis()+expiryTime))
                .withIssuer(issuer)
                .sign(algorithm);

    }


    public String getUsername(String token) {
        DecodedJWT decodedJWT = JWT.
                require(algorithm).
                withIssuer(issuer).   //verfication
                        build().              //JWTverifier
                        verify(token);

          return   decodedJWT.getClaim("name").asString();
    }

    // Add a new method for token validation

//    public String validateTokenAndGetUsername(String token) {
//        try {
//            DecodedJWT jwt = verifier.verify(token);
//            return jwt.getClaim("name").asString();
//        } catch (JWTVerificationException exception) {
//            // Token is not valid
//            return null;
//        }
   // }


}
