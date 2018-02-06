package main;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int numero = 1980;
		
		String numeroInStringa = String.valueOf(numero);
		
		System.out.println(numeroInStringa);
		
		char[] stringaInChar = numeroInStringa.toCharArray();
		
		for(char c : stringaInChar) {
			System.out.println(c);
		}
		
		for(int i = 0; i < stringaInChar.length; i++) {
			System.out.println(stringaInChar[i]);
		}
		
		System.out.println(Arrays.toString(stringaInChar));
	}

}
