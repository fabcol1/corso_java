package com.exercises.years.michele87;

public class NonRepeatingYearsTest {
	
	public static void main (String[] args) {
		int range_min = 1980 ;
		int range_max = 1987 ;
		NonRepeatingYearsTest nonRepeatingYears = new NonRepeatingYearsTest();
		//int count = nonRepeatingYears.count(range_min, range_max);
		System.out.println("From " + range_min + " to " + range_max + " there are " + nonRepeatingYears.count(range_min, range_max) + " of years with no repeated digits");
	}

	private int count(int range_min, int range_max) {
		int contatore = 0;
			for(int i=range_min; i<=range_max; i++) {				
				if(controllaDoppie(i)) 
					continue;
					contatore++;							
			}
		return contatore;
	}
	
	public static boolean controllaDoppie(int n) {
		boolean doppio = false;
		String d = Integer.toString(n);
		char[] c = d.toCharArray();
		for(int j=0; j<c.length; j++) {
			for(int i=j+1; i<c.length; i++) {
				if(c[j] == c[i]) {
					doppio = true;
				}
			}
		}
		return doppio;
	}

}


