package com.livesoft.smartfarm.configs;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.regex.Pattern;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.livesoft.smartfarm.exception.AuthorizationHeaderNotExistsException;
import com.livesoft.smartfarm.exception.InvalidTokenException;
import com.livesoft.smartfarm.exception.TokenExpiredException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.WeakKeyException;
import lombok.Setter;

@ConfigurationProperties(prefix = "smartfarm.token")
@Aspect
@Component
public class AuthorizationAspect {
	
	@Setter private String apiKey;
	@Setter private String secretKey;
	
	@Before("execution(public * com.livesoft.smartfarm.controllers.api.v1..*Controller.*(..)) ")
	public void insertAdminLog(JoinPoint joinPoint) throws WeakKeyException, UnsupportedEncodingException, TokenExpiredException {
		SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes("UTF-8"));
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();		
		String authorization = request.getHeader("Authorization");
		if(StringUtils.isBlank(authorization)){ 
			throw new AuthorizationHeaderNotExistsException();
		}
		if(Pattern.matches("^Bearer .*", authorization)) {
			authorization = authorization.replaceAll("^Bearer( )*", "");
			Jws<Claims> jwsClaims = Jwts.parserBuilder()
					.setSigningKey(key)
					.build()
					.parseClaimsJws(authorization);
			
			if(jwsClaims.getBody() != null) {
				Claims claims = jwsClaims.getBody();
				if(!claims.containsKey("apiKey") || !apiKey.equals(claims.get("apiKey").toString())
						|| claims.getExpiration() == null) {
					throw new InvalidTokenException();
				} 
				long exp = claims.getExpiration().getTime();
				if(exp < new Date().getTime()) {
					throw new TokenExpiredException();
				}
			}
		} else {
			throw new InvalidTokenException();
		}
	}	
}
