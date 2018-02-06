package ernestina;

//import static org.junit.Assert.*;



public class NonRepeatingYears {
	
	/*Write a program to count the number of years in an inclusive range of years that have no repeated digits.
	For example, 2012 has a repeated digit (2) while 2013 does not. 
	Given the range [1980, 1987], your program would return 7 (1980, 1982, 1983, 1984, 1985, 1986, 1987).*/
	
	public static void main (String[] args) {
		int range_min = 1980 ;
		int range_max = 1987 ;
		NonRepeatingYears nonRepeatingYears = new NonRepeatingYears();
		int count = nonRepeatingYears.count(range_min, range_max);
		System.out.println("From " + range_min + " to " + range_max + " there are " + count + " of years with no repeated digits");
//		assertEquals(7, count);
//		count = nonRepeatingYears.count(2000, 2013);
//		assertEquals(1, count);
	}
	
	private  int count(int range_max,int range_min) {
		int c = 0;int i = 0;
		for( i = range_min;i<= range_max;i++) {
			if(i>=range_min && i <= range_max ) {
				c++;
			
			}
			
			
		
	}
		return c;

	
		
	}
	public static boolean nonReaptingYears(int []a) {
		boolean res = false;
		for(int i = 0;i<a.length;i++) {
			for(int j = i+1;j<a.length;j++) {
				if(a[i]!= a[j]) {
					return res;
				}
			
			else {
				return  res = true;
			}
		}
		
	}
		return res;


}
}

