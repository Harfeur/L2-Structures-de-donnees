package fr.harfeur.structuresdonnees.tp04a.traduction;

import java.util.HashMap;
import java.util.Map;

public class Traduction_EN_FR {

    Map<String, String> dico;

    public Traduction_EN_FR() {
		this.dico = new HashMap<>();
		this.dico.put("a","un");
		this.dico.put("and","et");
		this.dico.put("algorithm","algorithme");
		this.dico.put("can","peut");
		this.dico.put("every","chaque");
		this.dico.put("give","donne");
		this.dico.put("knows","sait");
		this.dico.put("only","seulement");
		this.dico.put("poor","pauvre");
		this.dico.put("programmer","programmeur");
		this.dico.put("results","résultats");
		this.dico.put("the","le");
		this.dico.put("that","cela");
		this.dico.put("translation","traduction");
		this.dico.put("to","vers");
		this.dico.put("word","mot");
	}
    
    public String traduire(String str) {
    	String[] mots = str.split(" ");
    	String retour = "";
    	for (String mot : mots) {
    		if (this.dico.containsKey(mot)) retour += this.dico.get(mot) + " ";
    		else retour += "(" + mot + ") ";
		}
    	return retour;
    	
    }

    
   
    public static void main(String[] args) {
		String phrase="every programmer knows that a word to word translation algorithm can only give poor results and a better algorithm could improve the results of the translation";

		Traduction_EN_FR t = new Traduction_EN_FR();
		System.out.println(t.traduire(phrase));
    }

}
