package it.polito.libretto.model;

//classe di TEST per verificare il correto funzionamento della classe Model

public class TestModel {
	
	public static void main(String[] args){
		Model m=new Model();
		
		System.out.println(m.addEsame(new Esame("03FYZ", "Tecniche di Programmazione", "Fulvio Corno")));
		System.out.println(m.addEsame(new Esame("01QZP", "Ambient Intelligence", "Fulvio Corno")));
		
		//errore inserimento esame già presente
		System.out.println(m.addEsame(new Esame("03FYZ", "Tecniche di Programmazione", "Fulvio Corno")));
	
		System.out.println(m.trovaEsame("03FYZ"));
		System.out.println(m.trovaEsame("01QZP"));
		//errore codice esame non esistente
		System.out.println(m.trovaEsame("99QQQ"));		
	}

}
