package assertion;

public class TestAssertion {
	
	static {
		boolean assertsEnabled = false;
		assert assertsEnabled = true;
		if(!assertsEnabled) {
			throw new RuntimeException("Asserts must be enabled!");
		}
	}
	
	// ######################### PRE CONDIZIONI ##############################################
	// SEMPLICE ASSERTION CHE VA A BUON FINE
	public void simpleAssertionOK() {
		int b = 10;
		assert b > 0;
	}
	// SEMPLICE ASSERTION CHE NON VA A BUON FINE
	public void simpleAssertionKO() {
		int b = 10;
		assert b > 20 : "il valore di b è: " + b;
	}
	
//	1) È spesso consigliato (anche nella documentazione ufficiale Sun), 
//	non utilizzare pre-condizioni, per testare la correttezza dei parametri 
//	di metodi pubblici. È invece raccomandato l’utilizzo delle pre-condizioni
//	per testare la correttezza dei parametri di metodi privati, 
//	protetti o con visibilità a livello di package. 
//	Questo dipende dal fatto che un metodo non pubblico, 
//	ha la possibilità di essere chiamato da un contesto limitato, 
//	corretto e funzionante. Ciò implica che assumiamo che le nostre chiamate al 
//	metodo in questione sono corrette, ed è quindi lecito rinforzare tale concetto 
//	con un’asserzione.
	private String getInstanceString(int index) {
		assert ( index == 1 || index == 2) : "Index errato " + index;
		switch (index) {
		case 1:
			return "1";
		case 2:
			return "2";
		}
		return null;
	}
	
	//######################### POST CONDIZIONI ##############################################
	
	private boolean isOpen = false;
	
	private void open() {
		// .... codice 
		
		isOpen = true;
		
		// ... codice
		assert isOpen;
	}
	
	private void close() throws Exception {
		if(!isOpen) {
			throw new Exception("Impossibile chiudere connessioni non aperte!");
		}
		//....
		isOpen = false;
		//...
		assert !isOpen;
	}
	
	public static void main(String[] args) {
		TestAssertion t = new TestAssertion();
		//OK
		t.simpleAssertionOK();
//		//KO
//		t.simpleAssertionKO();
//		System.out.println("Non scrivo questa riga...");
	
		System.out.println(t.getInstanceString(4));
	}
	
}
