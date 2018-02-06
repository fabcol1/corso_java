package com.exercises.years.danieleg;
import com.exercises.years.DebugResultTest;

import java.util.ArrayList;

public class NonRepeatingYears extends DebugResultTest{

	public int count(int range_min, int range_max) {

		int k = 0, j = 0, count = 0;
		Boolean ok;
		ArrayList<String> anni = new ArrayList<String>();
		ArrayList<String> doppioni = new ArrayList<String>();
		for (k = 0; k <= (range_max - range_min); k++) {
			anni.add(Integer.toString((range_min + k)));
		}

		System.out.println("Date senza numeri replicati:");
		for (String s : anni) {
			ok = true;
			for (j = 0; j < s.length(); j++) {
				for (k = 0; k < s.length(); k++) {
					if ((k != j) && (s.charAt(j) == s.charAt(k))) {
						if (!doppioni.contains(Character.toString(s.charAt(j)))) {
							doppioni.add(Character.toString(s.charAt(j)));
						}
						ok = false;
						break;
					}
				}
			}
			if (ok) {
				count++;
				System.out.println(s);
			} else {
				System.out.println(s + " <<<--- NON Valida! I doppioni sono: " + doppioni.toString());
			}
			doppioni.clear();
		}

		return count;
	}

	public NonRepeatingYears() {
		super();
		authorName = "DanieleG";
	}

}
