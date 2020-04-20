package it.polito.tdp.anagrammi.model;

import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {

	private AnagrammaDAO adao;
	private Ricerca ric;
	
	public Model() {
		adao = new AnagrammaDAO();
		ric = new Ricerca();
	}
	
	public boolean isCorretto(String anagramma) {
		return this.adao.isCorretto(anagramma);
	}
	
	public Set<String> getAnagrammi(String parola){
		return this.ric.getAnagrammi(parola);
	}
	
}
