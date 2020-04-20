package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ricerca {

	private Set<String> soluzione;
	private String daAnagrammare;

	public Set<String> getAnagrammi(String parola){
		daAnagrammare = parola;
		this.soluzione = new HashSet<String>();
		parola = parola.toUpperCase();
		int livello = 0;
		List<Character> disponibili = new ArrayList<>();
		
		for(int i=0;i<parola.length();i++) {
		disponibili.add(parola.charAt(i));
		}
		
		//ricorsione("", livello, disponibili);
		ricorsione("",livello, disponibili);
		
		return this.soluzione;
	}
	
	public void ricorsione(String parziale, int livello, List<Character> disponibili) {
		
		if(disponibili.size()==0) {
			this.soluzione.add(parziale);
			return;
		}
		
		
		for(Character ch:disponibili) {
			String parola = parziale + ch;
			List<Character> rimanenti = new ArrayList<Character>(disponibili);
			rimanenti.remove(ch);
			ricorsione(parola, livello+1, rimanenti);
			
		}
		
	}

	
	
}
