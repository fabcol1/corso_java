package prova;

import java.util.Random;

public class Prova2 {

	static Random r = new Random();
	
	public static void main(String[] args) {
		Calcolo c = new Calcolo();
		int risultato = c.somma(r.nextInt(100), r.nextInt(100));
		System.out.println("Somma: " + risultato);
	}
}