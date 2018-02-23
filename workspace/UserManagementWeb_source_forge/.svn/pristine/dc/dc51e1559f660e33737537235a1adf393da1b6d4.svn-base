package utils;

import java.time.LocalDateTime;
import java.util.Random;

public class RandomToken {
	   static final String ALPHABET = LocalDateTime.now().toString();
	    static Random rnd = new Random(System.currentTimeMillis());
	    static private final int LENGHT = 8;
	 
	    public static String generate() {
	        StringBuilder sb = new StringBuilder(LENGHT);
	        for (int i = 0; i < LENGHT; i++) {
	            sb.append(ALPHABET.charAt(rnd.nextInt(ALPHABET.length())));
	        }
	        return sb.toString();
	    }
}
