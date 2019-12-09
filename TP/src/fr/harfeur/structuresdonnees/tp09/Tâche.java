package fr.harfeur.structuresdonnees.tp09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class T�che implements Comparable<T�che> {

	private int importance;
	private String libell�;
	
	public T�che(int importance, String libell�) {
		super();
		this.importance = importance;
		this.libell� = libell�;
	}

	@Override
	public int compareTo(T�che o) {
		if (this.importance == o.importance)
			return this.libell�.compareTo(o.libell�);
		return this.importance > o.importance ? -1 : 1;
	}

	@Override
	public int hashCode() {
		return Objects.hash(importance, libell�);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		T�che other = (T�che) obj;
		return importance == other.importance && libell�.equals(other.libell�);
	}
	
	@Override
	public String toString() {
		return String.format("(%s) %s", this.importance, this.libell�);
	}
	
	public static void main(String[] args) {
		ArrayList<T�che> t = new ArrayList<T�che>(5);
		t.add(new T�che(50, "Study some maths"));
		t.add(new T�che(40, "Order takeaway"));
		t.add(new T�che(75, "Learn Java"));
		t.add(new T�che(25, "Chill/watch movie"));
		t.add(new T�che(40, "Get some sleep"));
		
		Collections.sort(t);
		
		for (T�che t�che : t) {
			System.out.println(t�che);
		}
	}
	
	
}
