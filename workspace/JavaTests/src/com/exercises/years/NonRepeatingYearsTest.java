package com.exercises.years;

import com.exercises.years.fabcol.NonRepeatingYears;

//import static org.junit.Assert.*;



public class NonRepeatingYearsTest {
	
	/*Write a program to count the number of years in an inclusive range of years that have no repeated digits.
	For example, 2012 has a repeated digit (2) while 2013 does not. 
	Given the range [1980, 1987], your program would return 7 (1980, 1982, 1983, 1984, 1985, 1986, 1987).*/
	
	public static void main (String[] args) {
		int range_min = 0 ;
		int range_max = 9999 ;
		NonRepeatingYears nonRepeatingYears = new NonRepeatingYears();
		int count = nonRepeatingYears.count(range_min, range_max);
		System.out.println("From " + range_min + " to " + range_max + " there are " + count + " of years with no repeated digits");
//		assertEquals(7, count);
//		count = nonRepeatingYears.count(2000, 2013);
//		assertEquals(1, count);
	}
	

}

