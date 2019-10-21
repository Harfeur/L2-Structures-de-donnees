package fr.harfeur.structuresdonnees.tp04a.analyse_freq;

//import java.util.HashMap;

public class AnalyseFrequentielle {

    static String texteFR = "la cryptographie est une des disciplines de la cryptologie s'attachant a"
	    + "proteger des messages, assurant confidentialite, authenticite et integrite, en s'aidant souvent"
	    + "de secrets ou cles. elle se distingue de la steganographie qui fait passer inapercu un message"
	    + "dans un autre message alors que la cryptographie rend un message inintelligible a autre que"
	    + "qui de droit. elle est utilisee depuis l'antiquite, mais certaines de ses methodes les plus"
	    + "importantes comme la cryptographie asymetrique, datent de la fin du vingtieme siecle.";

    static String texteEN = "cryptography prior to the modern age was effectively synonymous with encryption,"
	    + "the conversion of information from a readable state to apparent nonsense. the originator of an"
	    + "encrypted message shared the decoding technique needed to recover the original information"
	    + "only with intended recipients, thereby precluding unwanted persons from doing the same."
	    + "the cryptography literature often uses alice for the sender, bob for the intended recipient, and eve"
	    + "for the adversary.";

    static String texteCS = "kryptografie neboli sifrovani je nauka o metodach utajovani smyslu zprav prevodem"
	    + "do podoby, ktera je citelná jen se specialni znalosti. slovo kryptografie pochazi z rectiny kryptos"
	    + "je skryty a graphein znamena psat. Nekdy je pojem obecneji pouzivan pro vedu o cemkoli spojenem se "
	    + "siframi jako alternativa k pojmu kryptologie. kryptologie zahrnuje kryptografii a kryptoanalyzu, "
	    + "neboli lusteni zasifrovanych zprav.";
    

/*    public char[] analyser(String str) {
    	char[] chars = str.toCharArray();
    	HashMap<Character, Integer> dico = new HashMap<Character, Integer>();
    	for (char c : chars) {
    		if (dico.containsKey(c)) dico.replace(c, dico.get(c) + 1);
    		else dico.put(c, 1);
		}
    	for (int i = 0; i < 6; i++) {
    		Character maxChar = 'a';
    		int maxInt = 0;
    		for (Character key : dico.keySet()) {
    			
    		}
		}
    }
    */
}
