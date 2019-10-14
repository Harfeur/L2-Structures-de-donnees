package fr.harfeur.structuresdonnees.tp04a;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Date {
	
	private int jour, annee;
	private String mois;
	
	public Date(int jour, String mois, int annee) {
		super();
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s %s", this.jour, this.mois, this.annee);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(annee, jour, mois);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		return annee == other.annee && jour == other.jour && Objects.equals(mois, other.mois);
	}

	public static void main(String[] args) throws IOException {
		
		HashMap<Date, String> datesRevolution = new HashMap<Date, String>();
		BufferedReader reader = new BufferedReader(new FileReader("ressources/tp04a/dates.csv"));
		String ligne = reader.readLine();
		while (ligne != null) {
			System.out.println(ligne);
			String[] str = ligne.split(";");
			datesRevolution.put(new Date(Integer.parseInt(str[0]), str[1], Integer.parseInt(str[2])), str[3]);
			ligne = reader.readLine();
		}
		reader.close();
		
		System.out.println(datesRevolution.get(new Date(14, "juillet", 1789)));
	}
	
}
