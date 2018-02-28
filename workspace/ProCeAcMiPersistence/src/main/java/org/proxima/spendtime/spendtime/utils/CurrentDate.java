package org.proxima.spendtime.spendtime.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDate {
	
	public static String data() {
		LocalDateTime data = LocalDateTime.now();
		String dataAttuale = data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		return dataAttuale;
	}
	
	public static String dataCorrente() {
		LocalDateTime data = LocalDateTime.now();
		String dataAttuale = data.format(DateTimeFormatter.ofPattern("MM-yyyy"));
		return dataAttuale;
	}
	
	public static String giornoCorrente() {
		LocalDateTime giorno = LocalDateTime.now();
		String today = giorno.format(DateTimeFormatter.ofPattern("dd"));
		return today;
	}

	public static void main(String[] args) {
		System.out.print(CurrentDate.giornoCorrente()+"-");
		System.out.println(CurrentDate.dataCorrente());
	}

}
