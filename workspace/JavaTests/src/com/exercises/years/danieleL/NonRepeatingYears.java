package com.exercises.years.danieleL;


import com.exercises.years.DebugResultTest;

  public class NonRepeatingYears extends DebugResultTest {

	
	public NonRepeatingYears () {
		super();
		
		authorName = "Daniele La Canna";
		
	}
	
		
	
	public int count (int range_min, int range_max) {
		
		
			 
		
		int counter = 0;
		boolean check = false;
		
		
		
		
		for (int f = range_min; f <= range_max;) {
			
			String anniStringa = Integer.toString(f);
			
//				System.out.println(anniStringa);
			
			
				    for (int i = 0; i < anniStringa.length(); i++) {
				
					    for (int j = i+1; j < anniStringa.length(); j++) {
					
						    if (anniStringa.charAt(i) == anniStringa.charAt(j)) {
	                	
							    check = true;
							    							    
							    counter--;
						    }
					   }
							
			 }
				
				    f++;
				    counter++;

				
					}
		
				return counter;
			
			
			
			
			
			
				}	

			
			
	
			
		}
		
		
			
					
	
	

	

		
		
		
				
		
		
		


	
	
	

	
	
	

