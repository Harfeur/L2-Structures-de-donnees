package fr.harfeur.structuresdonnees.synthese1;

import java.util.HashMap;

public class Main03 {

	public static void main(String[] args) {
		
		String sequence[] = {"aug","acu","auu","ggu","uuu","ccu","ccu","uug","aac","ggc","uuc","cgc","aaa","gga","auu","guc","ggg","ucc","ucg","guu","uuu","cuu","cgg","ggu","uug","aag","ugg","cga","auc","ggc","gac","uca","acc","gaa","aua","gca","acc","gac","cgu","aga","uug","guu","gug","caa","ucg","cgc","ggu","gcg","uau","ccc","aga","gcc","cac","ggg","cau","ggu","ccg","gcg","caa","acg","uua","uaa","cgg","uuu","ucu","ugg","cgc","ccu","ccc","gca","gag","ugu","ggu","gau","aau","cua","ugg","aua","uaa","aag","aaa","cca","aga","cca","ccg","agu","ggg","acg","ucg","acu","gag","agu","aca","ccc","cac","ucu","ugc","cga","agc","aua","uuc","aga","aua","agc","gug","aag","aga","ugu","auc","ugc","ggg","ggc","caa","aau","agu","ugc","aua","uug","cgu","ugc","cgc","agc","uuc","cgg","cuu","aac","ucc","aca","gau","uga","ggg","auc","aca","gga","gga","ccu","acg","agu","agc","gcg","gag","acg","gga","ccc","acu","ugg","ucu","aag","caa","cuu","ggu","cac","cca","uug","uac","cag","cag","cga","aca","uaa","gac","uag"};
		
		HashMap<String, Integer> effectifs = new HashMap<String, Integer>();
		
		for (String s : sequence) {
			if (effectifs.containsKey(s))
				effectifs.replace(s, effectifs.get(s) + 1);
			else
				effectifs.put(s, 1);
		}
		
		int maxValue = -1;
		String maxKey = "";
		
		for (String key : effectifs.keySet()) {
			Integer value = effectifs.get(key);
			if (value >= maxValue) {
				maxValue = value;
				maxKey = key;
			}
		}
		
		System.out.println(String.format("%s avec %s occurences", maxKey, maxValue));
		
	}

}
