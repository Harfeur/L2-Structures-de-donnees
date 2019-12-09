package fr.harfeur.structuresdonnees.tp09;

public class Tas<E extends Comparable<E>> {
	
	Object[] valeurs;
	int indiceMax;
	
	private static int CAPCT = 20;
	
	public Tas() {
		super();
		this.valeurs = new Object[CAPCT];
		this.indiceMax = -1;
	}
	
	public boolean estVide() {
		return this.indiceMax == -1;
	}
	
	@SuppressWarnings("unchecked")
	public void insérer(E e) {
		this.valeurs[this.indiceMax + 1] = e;
		int i = this.indiceMax + 1;
		int j = (i - 1) / 2;
		++this.indiceMax;
		while (i != 0 && e.compareTo((E) this.valeurs[j]) > 0) {
			this.valeurs[i] = this.valeurs[j];
			this.valeurs[j] = e;
			i = (i - 1) / 2;
			j = (i - 1) / 2;
		}
	}
	
	public void supprimer() {
		if (this.estVide()) return;
		this.valeurs[0] = this.valeurs[this.indiceMax];
		--this.indiceMax;
		this.tamiser(0);
	}

	@SuppressWarnings("unchecked")
	private void tamiser(int i) {
		int max = i;
		int fg = 2 * i + 1;
		int fd = 2 * i + 2;
		if (fg <= this.indiceMax && ((Comparable<E>) this.valeurs[fg]).compareTo((E) this.valeurs[max]) > 0 )
			max = fg;
		if (fd <= this.indiceMax && ((Comparable<E>) this.valeurs[fd]).compareTo((E) this.valeurs[max]) > 0 )
			max = fd;
		if (max != i) {
			E tmp = (E) this.valeurs[max];
			this.valeurs[max] = this.valeurs[i];
			this.valeurs[i] = tmp;
			this.tamiser(max);
		}
	}
	
	public static void main(String[] args) {
		Tas<Integer> tas = new Tas<Integer>();
		
		tas.insérer(12);
		tas.insérer(2);
		tas.insérer(15);
		tas.insérer(6);
		tas.insérer(52);
		tas.insérer(10);
		tas.insérer(32);
		tas.insérer(7);
		
		for (int j = 0; j < tas.indiceMax + 1; ++j) {
			int i = (int) tas.valeurs[j];
			System.out.print(i + " ");
		}
	}
	
}