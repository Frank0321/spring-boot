/**
 * @Description : jwt 的工具
 * @ClassName : JwtToken.java
 * @Copyright : Copyright (c) 2022 
 * @ModifyHistory : 
 *  v1.00, 2022/12/26, frankchang
 *   1) First Release.
 */

package com.example.springboot.utils;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

import javax.security.auth.message.AuthException;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class JwtToken implements Serializable {

	private static final long serialVersionUID = -3653711997173624177L;
	
	/***
	 * token 有效時間
	 */
	private static final long EXPIRATION_TIME = 1 * 60 * 1000;

	/***
	 * 驗證密碼
	 */
	private static final String SECRET = "secret";
	
	/***
	 * 簽發 jwt
	 */
	public String generateToken(Map<String, Object> claims) {
		
		return Jwts.builder()
				.setClaims(claims)
				.setExpiration(new Date(Instant.now().toEpochMilli()+EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512,SECRET)
				.compact();
	}
	
	/***
	 * 驗證 jwt
	 * @throws AuthException 
	 */
	public void validateToken(String token) throws AuthException {
		try {
			Claims claims = (Claims) Jwts.parser()
				.setSigningKey(SECRET)
				.parse(token).getBody();
			
			log.info("name : {}", claims.get("name").toString());
			log.info("pwd : {}", claims.get("pwd").toString());
			
		} catch (SignatureException e) {
            throw new AuthException("Invalid JWT signature.");
        }
        catch (MalformedJwtException e) {
            throw new AuthException("Invalid JWT token.");
        }
        catch (ExpiredJwtException e) {
            throw new AuthException("Expired JWT token");
        }
        catch (UnsupportedJwtException e) {
            throw new AuthException("Unsupported JWT token");
        }
        catch (IllegalArgumentException e) {
            throw new AuthException("JWT token compact of handler are invalid");
        }
		
	}
	
}
