package esempi;

public class EsempioCicli {
	public static void main(String[] args) {
		// CICLO FOR
		for(int i=0; i<10; i++) {
			System.out.println("L'indice �: " + i);
		}
		// CICLO WHILE
		int i = 0;
		while(i<10) {
			System.out.println("L'indice �: " + i++);
		}
		// CICLO DO WHILE
		do {
			System.out.println("L'indice �: " + i--);
		} while(i > 0);
		// BREAK
		for(i = 0; i < 100; i++) {
			if(i == 5) {
				break;
			}
			System.out.println("indice " + i);
		}
		// CONTINUE		
		for(i = 0; i < 100; i++) {
			if(i == 5) {
				continue;
			}
			System.out.println("indice " + i);
		}
	}
}
