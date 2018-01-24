/** 
*Questa è la descrizione della classe Prova

 **/
public class Prova {
/** campo finto con javadoc **/
public int x;

/** costruttore finto con javadoc **/
public Prova() {
}

/** metodo finto con javadoc **/ 
public void metodoFinto() { }
//	static {
//		System.out.println("inizializzatore blocco main");
//	}


	public static void main(String[] args) {
//		new Paperino();				
//		System.out.println("Hello World");
//		new Paperino();	
		System.out.println(args[0]);
	}
}
class Paperino {
	static {
		System.out.println("inizializzatore blocco");
	}
}