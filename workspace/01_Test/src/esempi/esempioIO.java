package esempi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;

import javax.swing.plaf.FileChooserUI;

public class esempioIO {
	public static void main(String[] args) {
		try {
//			readLocalFile();
//			writeLocalFile();
			copyPasteFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void readLocalFile() throws IOException {
		BufferedReader in = new BufferedReader(
			new FileReader("C:\\Users\\UTENTE9\\Desktop\\workspace\\prova.txt")
		);
		String s, s2 = new String();
		while((s = in.readLine()) != null) {
			s2 += s + "\n";
		}
		in.close();
		System.out.println(s2);
	}
	private static void writeLocalFile() throws IOException {
		String fileToWrite = "C:\\Users\\UTENTE9\\Desktop\\workspace\\dacopiare.txt";
		File f = new File(fileToWrite);
		// creo lo stream di output per file
		FileOutputStream fos = new FileOutputStream(f);
		// creo un printwriter per scrivere il file
		PrintWriter pw = new PrintWriter(fos);
		// scrivo sul file la riga ciao
		pw.println("ciao");
		pw.println("weeeeee");
		pw.close();
		fos.close();
	}
	
	private static void copyPasteFile() throws IOException {
		String fileToCopy= "C:\\Users\\UTENTE9\\Desktop\\workspace\\dacopiare.txt";
		File f = new File(fileToCopy);
		
		if(f.exists()) {
			String mkdir = "C:\\Users\\UTENTE9\\Desktop\\workspace\\backupDir";
			File dir = new File(mkdir);
			
			int i = 0;
			
			while(dir.exists() && !dir.isDirectory()) {
				if(i > 0) {
					mkdir = mkdir.substring(0, (mkdir.length()-2));	
				}
				mkdir += "_" + i;
				dir = new File(mkdir);
				i++;
			}
			//se arriva qua o NON ESISTE oppure SE ESISTE � UNA DIRECTORY
			if(!dir.exists()) {
				dir.mkdir();
			}
			
			File dest = new File(mkdir + "\\fileDiBackup.bak");
			
			i = 0;
			while(dest.exists()) {
				dest = new File(mkdir + "\\fileDiBackup" + i++ +".bak");
			}
			
			copy(f,dest);
		}
	}
	
	public static void copy(File src, File dst) throws IOException {
	    InputStream in = new FileInputStream(src);
	    try {
	        OutputStream out = new FileOutputStream(dst);
	        try {
	            // Transfer bytes from in to out
	            byte[] buf = new byte[1024];
	            int len;
	            while ((len = in.read(buf)) > 0) {
	                out.write(buf, 0, len);
	            }
	        } finally {
	            out.close();
	        }
	    } finally {
	        in.close();
	    }
	}
}


