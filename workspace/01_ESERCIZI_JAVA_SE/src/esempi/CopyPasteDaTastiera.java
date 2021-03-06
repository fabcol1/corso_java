package esempi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CopyPasteDaTastiera {
	public static final String DEFAULT_BACKUP_DIR = "C:\\Users\\UTENTE9\\Desktop\\corso_java\\corso_java\\workspace\\backupDir_2";

	public static void main(String[] args) throws IOException {
		
		BufferedReader stdin = new BufferedReader(
				new InputStreamReader(System.in)
		);
		
		System.out.println("Inserisci il percorso completo del file da copiare: ");
		String absoluteInputFileName = stdin.readLine();
		System.out.println("Il nome assoluto del file da copiare �: " + absoluteInputFileName);
		File absoluteInputFile = new File(absoluteInputFileName);
		System.out.println("Verifico se esiste...");
		if(absoluteInputFile.exists()) {
			startFileCopy(absoluteInputFile);
			System.out.println("Copia terminata...");
		} else {
			System.out.println("Il File: " + absoluteInputFileName + " NON ESISTE. APPLICAZIONE TERMINATA");
		}
	}
	
	public static void startFileCopy(File absoluteInputFile) throws IOException {
		String outputFileName = getOutputFileName(absoluteInputFile.getName());
		System.out.println("outputFileName: " + outputFileName);
		BufferedReader in = new BufferedReader(new FileReader(absoluteInputFile));
		String outputAbsolutePathFileName = DEFAULT_BACKUP_DIR + System.getProperty("file.separator") +  outputFileName ;
		System.out.println("outputAbsolutePathFileName: " + outputAbsolutePathFileName);
		File outputF  = new File(outputAbsolutePathFileName);
		
		FileOutputStream fos = new FileOutputStream(outputF);
		PrintWriter pw = new PrintWriter(fos);

		String s, s2 = new String();
		while((s = in.readLine()) != null) {
				s2 += s + "\n";
				pw.println(s);
		}
		
		pw.write(s2);
		in.close();
		pw.close();
		System.out.println(s2);
		
	}
	
	public static String getOutputFileName(String relativeInputFileName) {
	    SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
		String outputFileName =  dt1.format(new Date())  + "_" + relativeInputFileName;
		return outputFileName;
	}


}
