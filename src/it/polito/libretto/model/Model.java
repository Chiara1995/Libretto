package it.polito.libretto.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.libretto.db.EsameDAO;

//Classe principale che gestisce dati di tipo Esame

public class Model {
	
	private List<Esame> esami;
	
	public Model(){
		esami=new ArrayList<Esame>();
	}
	
	/**
	 * Aggiunge un nuovo esame all'elenco degli esami presenti, verificando che l'esame non sia già presente nella lista.
	 * @param e
	 * @return true se l'ha inserito, false se esisteva già e quindi non l'ha potuto inserire
	 */
	
	// Gestione anomalie ed errori relativi a metodi che possono provocare una failure 
	// 1)silent failure, gestione silenziosa dell'errore (non fa niente, ignora)
	// 2)restituire un boolean, valore indica se l'operazione è andata a buon fine o meno
	// 3)scatenare un'eccezione, segnala l'errore all'utente
	
	//MANTENERE COERENZA E INTEGRITA' DEI DATI
	
	public boolean addEsame(Esame e){
		/*
		 SENZA DATABASE
		 
		 if(!esami.contains(e)){
		 	esami.add(e);
			return true;
		 }
		 else
			return false;
		*/
		
		EsameDAO dao=new EsameDAO();
		return dao.create(e);
		
	}
	
	/**
	 * Ricerca se esiste un esame con il codice specificato.
	 * Se esiste lo restituisce, altrimenti restituisce null.
	 * @param codice codice dell'esame da ricercare
	 * @return l'esame trovato oppure null se non trovato
	 */
	
	public Esame trovaEsame(String codice){
		/*
		 SENZA DATABASE
		 
		 int pos=esami.indexOf(new Esame(codice, null, null));
		 if(pos==-1)
		 	return null;
		 else
			return esami.get(pos);
		*/
		
		EsameDAO dao=new EsameDAO();
		Esame e=dao.find(codice);
		return e;
		
	}
		
			

}
