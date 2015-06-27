package com.nit.gooapi.json;

import java.util.HashMap;

public class TokenHolder {

	
	private HashMap<String, GoogleTokenResponse> tokenHolder = new HashMap<String, GoogleTokenResponse>();

	public HashMap<String, GoogleTokenResponse> getTokenHolder() {
		return tokenHolder;
	}

	public void setTokenHolder(HashMap<String, GoogleTokenResponse> tokenHolder) {
		this.tokenHolder = tokenHolder;
	}
	
	
	
	
	
}
