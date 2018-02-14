package com.exercises.years.fabcol;

import java.util.HashSet;
import java.util.Set;

import com.exercises.years.DebugResultTest;

public class NonRepeatingYears extends DebugResultTest {

	public NonRepeatingYears() {
		authorName = "FabCol";
	}
	
	public int count(int range_min, int range_max) {
		int nonRepeatingYears = 0;
		
		for (int i = range_min; i <= range_max; i++) {

			String stringVal;
			try {
				stringVal = String.valueOf(i);
			} catch (Exception e) {
				return -1;
			}
			if(isNotRepeating(stringVal)) {
				nonRepeatingYears++;
			}
		}
		return nonRepeatingYears;
	}
	
	private int getRepeatingVal(String s) {
		char[] charArray = s.toCharArray();
		int size = charArray.length;
		for(int i = 0; i < size-1; i++) {
			for(int j = i+1; j < size; j++) {
				if(charArray[i] == charArray[j]) {
					return 0;
		}}}
//		System.out.println(s);
		return 1;
	}
	
	private boolean isNotRepeating(String s) {
		char[] charArray = s.toCharArray();
		int size = charArray.length;
		Set<Character> caratteri = new HashSet<>();
		
		for(char c : charArray) {
			caratteri.add(c);
		}
		
		return (caratteri.size() == size);
	}
}