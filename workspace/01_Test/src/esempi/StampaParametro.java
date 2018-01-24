package esempi;

public class StampaParametro {

	public static void main(String[] args) {
		esercizio3(args);
	}
	
	public static void esercizio1(String[] args) {
		for(String s : args) {
			if(s!=null) {
				System.out.print(s + " " );
			}
		}
	}
	
	public static void esercizio2(String[] args) {
		for(String s : args) {
			if(s!=null) {
				int x = 0;
				try {
					x = Integer.parseInt(s);
				} catch (Exception e) {
					
				}
				System.out.print(x + " " );
			}
		}
	}
	
	public static void esercizio3(String[] args) {
		if(args[2]==null) {
			System.out.println("nessuna operazione selezionata");
			return;
		}
		double risultato;
		int x, y;
		try {
			x = Integer.parseInt(args[0]);
			y = Integer.parseInt(args[0]);
		} catch(Exception ex) {
			System.out.println("parametri non validi");
			return;
		}
		
		switch(args[2]) {
		case "somma" : 
			risultato = x + y;
			System.out.println("Risultato: " + risultato);
			break;
		case "sottrazione" :
			risultato = x - y;
			System.out.println("Risultato: " + risultato);
			break;
		case "moltiplicazione" :
			risultato = x * y;
			System.out.println("Risultato: " + risultato);
			break;
		case "divisione" :
			risultato = x / y;
			System.out.println("Risultato: " + risultato);
			break;
		default: 
			System.out.println("nessuna operazione disponibile");
			break;
		}
	}

}

// 1 - inserisco 3 stringhe
// 2 - inserisco 3 numeri
// 3 - inserisco 2 numeri + stringa che identifica tipo di operazione + - / * %