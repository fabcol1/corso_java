package esempi;

public class StaticField {
	
	public static void main(String[] args) {
		Implementazione i1 = new Implementazione();
		Implementazione i2 = new Implementazione();
		
		i1.numero = 12;
		
		System.out.println("il valore per i1 = " + i1.numero);
		System.out.println("il valore per i2 = " + i2.numero);
		
	}
}

class Implementazione {
	public static int numero;
}


