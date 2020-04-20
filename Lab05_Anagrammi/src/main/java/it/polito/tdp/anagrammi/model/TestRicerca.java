package it.polito.tdp.anagrammi.model;

import java.util.Set;

public class TestRicerca {

	public static void main(String[] args) {

		Ricerca r = new Ricerca();
		
		Set<String> prova = r.getAnagrammi("figlio");
		System.out.println(prova);
		
		Set<String> prova1 = r.getAnagrammi("immaturo");
		System.out.println(prova1);
	}

}
