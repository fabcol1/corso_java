package es.localDateTime;

import java.io.File;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import test.Message;

public class LocalDateTimeExamples {
	public static void main(String[] args) {
		LocalDateTime today = LocalDateTime.now();
		System.out.println("Today is: " + today);
		
		//Current Date using LocalDate and LocalTime
		today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("Current DateTime="+today);
		
//		System.out.println(today.format(DateTimeFormatter.ofPattern("YYYYMMDD_HHmmss")));	
		
		// TIME STAMP BELLO PER FILE
		LocalDateTime data = LocalDateTime.now();
		String dataString = data.format(DateTimeFormatter.ofPattern("yyyMMdd_HHmmss_SSSS")); 
		System.out.println(dataString);	
		
//		File f = new File("C:\\Users\\UTENTE9\\Desktop\\corso_java\\corso_java\\messaggiSerializzati\\");
//		ArrayList<Message> messages = new ArrayList<>();
//		File[] files = f.listFiles();
//		
//		for(File file : files) {
//			System.out.println(file.getName());
//		}
	}
}
