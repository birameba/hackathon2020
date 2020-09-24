package com.htc.payload;

import org.springframework.beans.factory.annotation.Value;

import com.htc.security.JwtTokenProvider;

/**
 * Created by Birame Ba on 11/09/19.
 */
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    
    @Value("${security.jwt.token.expire-length:604800000}")
    private long validityInMilliseconds = 604800000; // 1h

   
    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

	public long getValidityInMilliseconds() {
		return validityInMilliseconds;
	}

	public void setValidityInMilliseconds(long validityInMilliseconds) {
		this.validityInMilliseconds = validityInMilliseconds;
	}

	

	
}
