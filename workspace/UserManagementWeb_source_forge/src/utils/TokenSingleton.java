package utils;

import java.util.*;

public class TokenSingleton {
	
	private static TokenSingleton tokenSingleton;
	
	private Map<String,String> tokenMail; 
	
	private TokenSingleton() {
		tokenMail = new HashMap<>();
	}
	
	public static synchronized TokenSingleton getTokenSingleton() {
		if(tokenSingleton == null) {
			tokenSingleton = new TokenSingleton();
		}
		return tokenSingleton;
	}
	
	public Map<String, String> getTokenMail() {
		return tokenMail;
	}
}
