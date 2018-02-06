package com.exercises.years.francesco;

public class NonRepeatingYears extends DebugResultTest {

	
	public NonRepeatingYears() {
		authorName = "Francesco";
	}
	
	public int count(int range_min, int range_max) {
		// TODO Auto-generated method stub
		int risultato = 0;
		
		for(int i=range_min; i<=range_max; i++) {				
			if(verify(i)) 
				continue;
				risultato++;							
		}
		
		return risultato;
	}

	public static boolean verify(int a) {
		boolean doppion = false;
		String d = Integer.toString(a);
		char[] c = d.toCharArray();
		for(int i=0; i<c.length; i++) {
			for(int j=i+1; i<c.length; i++) {
				if(c[j] == c[i]) {
					doppion = true;
				}
			}
		}
		return doppion;
	}
	
	

}
