package com.exercises.years.fabCas;

import java.util.HashMap;
import java.util.Map;

import com.exercises.years.DebugResultTest;

public class NonRepeatingYears extends DebugResultTest {
	
	public NonRepeatingYears() {
		super();
		this.authorName="FabCassetta";
	}

	public int count(int range_min, int range_max) {
		int result = 0;
		for (int i = range_min; i < range_max + 1; i++) {
			result+= verifyProperty(i);
		}
		
		return result;
	}

	private int verifyProperty(int i) {
		String number = Integer.toString(i);
		Map<Character, Integer> occurrence = new HashMap<>();
		boolean occurrencesCount = true;
		for (int j = 0; j < number.toCharArray().length; j++) {
			if(occurrence.containsKey(number.toCharArray()[j])) {
				occurrence.replace(number.toCharArray()[j], occurrence.get(number.toCharArray()[j])+1);
			}
			else {
				occurrence.put(number.toCharArray()[j], 1);
			}
		}
		
		for(Integer integ : occurrence.values()) {
			if(integ > 1)
				occurrencesCount = false;
		}
		
		if(occurrencesCount)
			return 1;
		
		return 0;
	}

}
