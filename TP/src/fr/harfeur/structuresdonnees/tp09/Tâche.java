package fr.harfeur.structuresdonnees.tp09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Tâche implements Comparable<Tâche> {

	private int importance;
	private String libellé;
	
	public Tâche(int importance, String libellé) {
		super();
		this.importance = importance;
		this.libellé = libellé;
	}

	@Override
	public int compareTo(Tâche o) {
		if (this.importance == o.importance)
			return this.libellé.compareTo(o.libellé);
		return this.importance > o.importance ? -1 : 1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(importance, libellé);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tâche other = (Tâche) obj;
		return importance == other.importance && libellé.equals(other.libellé);
	}
	
	@Override
	public String toString() {
		return String.format("(%s) %s", this.importance, this.libellé);
	}
	
	public static void main(String[] args) {
		ArrayList<Tâche> t = new ArrayList<Tâche>(5);
		t.add(new Tâche(50, "Study some maths"));
		t.add(new Tâche(40, "Order takeaway"));
		t.add(new Tâche(75, "Learn Java"));
		t.add(new Tâche(25, "Chill/watch movie"));
		t.add(new Tâche(40, "Get some sleep"));
		
		Collections.sort(t);
		
		for (Tâche tâche : t) {
			System.out.println(tâche);
		}
	}
	
	
}
