package com.exercises.years.fabcol;

public class NonRepeatingYears {

	public int count(int range_min, int range_max) {
		int nonRepeatingYears = 0;
		
		for (int i = range_min; i <= range_max; i++) {

			String stringVal;
			try {
				stringVal = String.valueOf(i);
			} catch (Exception e) {
				return -1;
			}
			nonRepeatingYears += nonRepeatingYear(stringVal);
		}
		return nonRepeatingYears;
	}
	
	private int nonRepeatingYear(String s) {
		
		char[] charArray = s.toCharArray();

		for(int i = 0; i < charArray.length-1; i++) {
			for(int j = i+1; j < charArray.length; j++) {
				if(charArray[i] == charArray[j]) {
					return 0;
				}
			}
		}
		return 1;
	}
}
