package com.exercises.parkomatic;

import java.util.HashMap;
import java.util.Map;

import javax.management.ImmutableDescriptor;

public class Parkomatic {

	private static final Map<Integer, String> numeroLetteraMap = new HashMap<Integer, String>() {
		{
			put(0, "A");
			put(1, "B");
			put(2, "C");
			put(3, "D");
			put(4, "E");
			put(5, "F");
		}
	};
	
	Map<Integer, String[]> mappa = new HashMap<>();
	
	public Parkomatic(int... num) {
		int count = 0;
		int size = num.length;
		if(size>6) {
			size = 6;
		}
		for(int i = 0; i < size; i++) {
			if(num[i]>200) {
				num[i] = 200;
			}
			for(int j = 1; j <= num[i]; j++) {
				mappa.put(count, new String[] { numeroLetteraMap.get(i), String.valueOf(j)});
				count++;
			}
		}
	}
	
	public String print(int i) {
		StringBuilder sb = new StringBuilder();
		String[] s = mappa.get(i);
		sb.append(s[0] + s[1]);
		return sb.toString();
	}
	
}
