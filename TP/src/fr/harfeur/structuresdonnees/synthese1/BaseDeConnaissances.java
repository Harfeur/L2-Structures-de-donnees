package fr.harfeur.structuresdonnees.synthese1;

import java.util.HashMap;

@SuppressWarnings("serial")
public class BaseDeConnaissances extends HashMap<Objet, String> {
	
	public BaseDeConnaissances() {
		super();
		this.put(new Objet("petit", "rond", "noir"), "point");
	}
	
}