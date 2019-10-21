package fr.harfeur.structuresdonnees.tp04b;

public class Couple<E, F> {
	
	E key;
	F value;
	boolean del;
	
	public Couple(E key, F value) {
		super();
		this.key = key;
		this.value = value;
		this.del = false;
	}
	
	@Override
	public String toString() {
		return String.format("<%s,%s>", this.key, this.value);
	}
}
