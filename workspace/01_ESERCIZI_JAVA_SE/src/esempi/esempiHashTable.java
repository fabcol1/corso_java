package esempi;

import java.util.Hashtable;

public class esempiHashTable {
	public static void main(String[] args) {
		Hashtable<Integer,String> appoHash = new Hashtable<>();
		
		for(int i=0; i<100; i++) {
			appoHash.put(new Integer(i), "Ciao a tutti sono l'indice: " + i);
		}
		
		System.out.println("appoHash.size(): " + appoHash.size());
		
		System.out.println(appoHash.get(new Integer(0)));
		System.out.println(appoHash.get(new Integer(30)));
		System.out.println(appoHash.get(new Integer(57)));
	}
}
