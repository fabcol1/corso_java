package esempi;

public class EsempioSwitch {

	public static void main(String[] args) {
		switch(args[0]) {
		case "primo" :
			System.out.println("primo");
		case "secondo" :
			System.out.println("secondo");
			break;
		case "terzo" :
			System.out.println("terzo");
		}
		
		System.out.println(( "ciao".equals(args[0])  ? "true"  : "false" ));
		
	}
}
