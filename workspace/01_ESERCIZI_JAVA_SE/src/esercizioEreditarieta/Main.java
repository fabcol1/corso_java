package esercizioEreditarieta;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
//		esercizioInstanceOf(args);
//		esercizioArray(args);	
		esercizioArrayList(args);
	}
	
	private static void esercizioArrayList(String[] args) {
		if(args.length == 0) {
			System.out.println("Non hai inserito il parametro");
			return;
		}
		int args0;
		try {
			args0 = Integer.parseInt(args[0]);
		} catch(NumberFormatException e) {
			System.out.println("Non hai inserito un parametro corretto: " + e.getMessage());
			e.printStackTrace();
//			System.exit(0);
			return;
		}
		
		Random r = new Random();
		int dim = r.nextInt(100) * args0;

		ArrayList<EssereVivente> arrayDiEsseri = new ArrayList<>();
		
		for(int i = 0; i < dim; i++) {
		
			switch(r.nextInt(3)) {
			case 0:
				arrayDiEsseri.add(new Uomo());
				break;
			case 1:
				arrayDiEsseri.add(new Cane());
				break;
			case 2:
				arrayDiEsseri.add(new Pesce());
				break;
			};
		}
		
		for(int i = 0; i < dim; i++) {
			System.out.println(i + " " + arrayDiEsseri.get(i).getClass().getSimpleName());
		}
		
	}
	
	private static void esercizioArray(String[] args) {
		if(args.length == 0) {
			System.out.println("Non hai inserito il parametro");
			return;
		}
		int args0;
		try {
			args0 = Integer.parseInt(args[0]);
		} catch(NumberFormatException e) {
			System.out.println("Non hai inserito un parametro corretto: " + e.getMessage());
			e.printStackTrace();
//			System.exit(0);
			return;
		}
		
		Random r = new Random();
		int dim;
		
		try {
			dim = r.nextInt(100) * args0;
		} catch(IllegalArgumentException e) {
			dim = 10;
		}

		EssereVivente[] arrayDiEsseri = new EssereVivente[dim];
		
		for(int i = 0; i < dim; i++) {
		
//			int x = r.nextInt(3);
//			
//			if(x == 2) arrayDiEsseri[i] = new Pesce();
//			arrayDiEsseri[i] = x == 0 ? new Uomo() : new Cane();
			switch(r.nextInt(3)) {
			case 0:
				arrayDiEsseri[i] = new Uomo();
				break;
			case 1:
				arrayDiEsseri[i] = new Cane();
				break;
			case 2:
				arrayDiEsseri[i] = new Pesce();
				break;
			};
		}
		
		for(int i = 0; i < dim; i++) {
			System.out.println(i + " " + arrayDiEsseri[i].getClass().getSimpleName());
		}
		
	}
	
	private static void esercizioInstanceOf(String[] args) {
		if(args.length == 0) {
			System.out.println("Non hai inserito il parametro");
			return;
		}
		
		EssereVivente aaa = null;
		
		switch(args[0]) {
		case "cane" : 
			aaa = new Cane();
			break;
		case "uomo" :
			aaa = new Uomo();
			break;
		case "pesce" :
			aaa = new Pesce();
			break;
		default: 
			aaa = new EssereVivente();
			break;
		}
		
		if(aaa instanceof EssereVivente) {
			System.out.println("� anche un essere vivente");
		}
		
		if(aaa instanceof Cane) {
			System.out.println("aaa � un Cane " + aaa.getClass());
		} else if(aaa instanceof Uomo) {
			System.out.println("aaa � un Uomo "+ aaa.getClass());
		} else if(aaa instanceof Pesce) {
			System.out.println("aaa � un Pesce "+ aaa.getClass());
		} else {
			System.out.println(aaa.getClass());
		}
	}
}


