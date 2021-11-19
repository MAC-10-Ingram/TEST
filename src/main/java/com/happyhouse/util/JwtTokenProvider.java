package com.happyhouse.util;

import java.time.Duration;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.happyhouse.model.UserInfoDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

  private final JwtProperties jwtProperties
   = new JwtProperties("ssafy", "secret", "prefix");
  
  public boolean checkToken(String token, String id) {
	  Claims c = getClaims(token);
	  System.out.println(id+" == "+c.get("id"));
	  if(!id.equals((String)c.get("id"))) return false;
	  
	  long t = new Date().getTime();
	  
	  System.out.println(t+" == "+c.get("exp"));
	  if((t/1000) > (Integer)c.get("exp")) return false;
	  
	  return true;
  }
  
  public String makeJwtToken(UserInfoDto user) {
    Date now = new Date();

    return Jwts.builder()
        .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
        .setIssuer(jwtProperties.getIssuer())
        .setIssuedAt(now)
        .setExpiration(new Date(now.getTime() + Duration.ofMinutes(30).toMillis()))
        .claim("id", user.getId())
        .claim("email", user.getEmail())
        .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())
        .compact();
  }

  public Claims getClaims(String authorizationHeader) {
    validationAuthorizationHeader(authorizationHeader);

    String token = extractToken(authorizationHeader);
    return parsingToken(token);
  }

  private Claims parsingToken(String token) {
    return Jwts.parser()
        .setSigningKey(jwtProperties.getSecretKey())
        .parseClaimsJws(token)
        .getBody();
  }

  private void validationAuthorizationHeader(String header) {
    if (header == null || !header.startsWith(jwtProperties.getTokenPrefix())) {
      throw new IllegalArgumentException();
    }
  }

  private String extractToken(String authorizationHeader) {
    return authorizationHeader.substring(jwtProperties.getTokenPrefix().length());
  }

}

