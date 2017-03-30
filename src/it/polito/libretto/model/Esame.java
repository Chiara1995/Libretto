package it.polito.libretto.model;

import java.time.LocalDate;

/**
 * Oggetto semplice che contiene i dati relativi ad un singolo esame.
 * POJO (Plain Old Java Object)
 * - dati privati (proprietà)
 * - cotruttore
 * - metodi get/set 
 * - metodi di servizio (toString, equals, hashCode, [compareTo])
 */

//equals si basa su criterio di uguaglianza
//compareTo si basa su un criterio di ordinamento

public class Esame {

	private String codice;
	private String titolo;
	private String docente;
	//oppure
	//private Docente docente;
	private boolean superato;
	private int voto;
	//per le date classe java.time (LocalDate) e NON java.util (Date)
	private LocalDate dataSuperamento;
	
	/**
	 * Nuovo esame, non ancora superato
	 * 
	 * @param codice codice dell'esame
	 * @param titolo denominazione del corso
	 * @param docente cognome e nome del docente titolare
	 */
	
	public Esame(String codice, String titolo, String docente) {
		super();
		this.codice = codice;
		this.titolo = titolo;
		this.docente = docente;
		//quando costruisco un oggetto Esame, questo è riferito ad un esame non ancora superato
		this.superato=false;
	}

	/**
	 * @return the codice
	 */
	public String getCodice() {
		return codice;
	}

	/**
	 * @param codice the codice to set
	 */
	public void setCodice(String codice) {
		this.codice = codice;
	}

	/**
	 * @return the titolo
	 */
	public String getTitolo() {
		return titolo;
	}

	/**
	 * @param titolo the titolo to set
	 */
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	/**
	 * @return the docente
	 */
	public String getDocente() {
		return docente;
	}

	/**
	 * @param docente the docente to set
	 */
	public void setDocente(String docente) {
		this.docente = docente;
	}

	/**
	 * @return the superato
	 */
	public boolean isSuperato() {
		return superato;
	}

	/**
	 * @param superato the superato to set
	 */
	private void setSuperato(boolean superato) {
		this.superato = superato;
	}

	/**
	 * Restituisce il voto solo se l'esame è stato superato, altrimenti eccezione.
	 * @return the voto
	 */
	public int getVoto() {
		if(this.superato)
			return voto;
		else
			throw new IllegalStateException("Esame "+this.codice+" non ancora superato");
	}

	/**
	 * @param voto the voto to set
	 */	
	private void setVoto(int voto) {
		this.voto = voto;
	}

	/**
	 * @return the dataSuperamento
	 */
	public LocalDate getDataSuperamento() {
		if(this.superato)
			return dataSuperamento;
		else
			throw new IllegalStateException("Esame "+this.codice+" non ancora superato");
	}

	/**
	 * @param dataSuperamento the dataSuperamento to set
	 */
	private void setDataSuperamento(LocalDate dataSuperamento) {
		this.dataSuperamento = dataSuperamento;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Esame [codice=" + codice + ", titolo=" + titolo + ", docente=" + docente + ", superato=" + superato
				+ ", voto=" + voto + ", dataSuperamento=" + dataSuperamento + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codice == null) ? 0 : codice.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	//definisco metodo equals per stabilire un criterio di uguaglianza tra oggetti specifico
	//per poter utilizzare metodo contains e indexOf su una lista
	//in quanto l'equals predefinito a livello di Object confronta semplicemente l'indirizzo di memoria
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (codice == null) {
			if (other.codice != null)
				return false;
		} else if (!codice.equals(other.codice))
			return false;
		return true;
	}
	
	/**
	 * Se l'esame non è ancora superato, lo considera superato con il voto e la data specificati.
	 * Se invece l'esame era già superato, genera un'eccezione.
	 * 
	 * @param voto
	 * @param data
	 */
	public void supera(int voto, LocalDate data){
		if(!this.superato){
			//non ancora superato OK
			this.superato=true;
			this.voto=voto;
			this.dataSuperamento=data;
		}
		else{
			//già superato KO
			//IllegalStateException eccezione di tipo runtime (chiamato metodo su oggetto il cui stato interno non permette di chiamare quel metodo) 
			throw new IllegalStateException("Esame "+this.codice+" già superato");
		}
	}
	
}
