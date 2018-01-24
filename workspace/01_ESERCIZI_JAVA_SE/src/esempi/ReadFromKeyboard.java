package esempi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFromKeyboard {

	public static void main(String[] args) throws IOException {
		leggiSdin();
	}
	
	private static void leggiSdin() throws IOException {
		// leggere da Standard input
		BufferedReader stdin = new BufferedReader(
				new InputStreamReader(System.in)
		);
		
//		Scanner scanner = new Scanner(System.in);
		
		String line = null;
		do {
			if(line!=null) {
				System.out.println(line);
			}
			System.out.println("Enter a line: ");
		} while(!(line = stdin.readLine()).equals("quit"));
	}

}
