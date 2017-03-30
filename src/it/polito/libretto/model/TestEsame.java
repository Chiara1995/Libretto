package it.polito.libretto.model;

import java.time.LocalDate;

//classe di TEST per verificare il correto funzionamento di un oggetto Esame

public class TestEsame {
	
	public static void main(String[] args){
		Esame tdp=new Esame("03FYZ", "Tecniche di Programmazione", "Fulvio Corno");
		System.out.println(tdp);
		Esame ami=new Esame("01QZP", "Ambient Intelligence", "Fulvio Corno");
		System.out.println(ami);
		System.out.println(ami.equals(tdp));
		
		//per avere la data attuale LocalDate.now()
		tdp.supera(30, LocalDate.now());
		System.out.println(tdp);
		
		//eccezione esame già superato
		tdp.supera(18, LocalDate.now());
		System.out.println(tdp);
	}

}
