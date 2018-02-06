package com.exercises.years;

//import static org.junit.Assert.*;



public abstract class DebugResultTest {

	protected String authorName = "" ;
	
	public abstract int count (int rangeMin, int rangeMax) ;
	
	public void debugTest (int rangeMin, int rangeMax) {
		int count = count(rangeMin, rangeMax);
		System.out.println("SOLUTION for " + authorName);
		System.out.println("From " + rangeMin + " to " + rangeMax + " there are " + count + " of years with no repeated digits");
	}
	
}
