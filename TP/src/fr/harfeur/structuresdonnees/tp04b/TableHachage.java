package fr.harfeur.structuresdonnees.tp04b;

public class TableHachage<Cl�, Valeur> implements Dictionnaire<Cl�, Valeur> {

	private Couple<Cl�,Valeur>[] donn�es;
	private static int CAPCT = 15;
	
	@SuppressWarnings("unchecked")
	public TableHachage() {
		super();
		this.donn�es = new Couple[CAPCT];
	}
	
	@Override
	public void ajouter(Cl� c, Valeur v) throws ExceptionCl�D�j�Existante {
		int h = Math.abs(c.hashCode() % CAPCT);
		if (this.donn�es[h] != null) throw new ExceptionCl�D�j�Existante(c);
		Couple<Cl�, Valeur> couple = new Couple<Cl�, Valeur>(c, v);
		this.donn�es[h] = couple;
	}

	@Override
	public void supprimer(Cl� c) {
		int h = Math.abs(c.hashCode() % CAPCT);
		this.donn�es[h] = null;
	}

	@Override
	public boolean estPr�sent(Cl� c) {
		int h = Math.abs(c.hashCode() % CAPCT);
		if (this.donn�es[h] == null) return false;
		return this.donn�es[h].key == c;
	}

	@Override
	public Valeur rechercher(Cl� c) throws ExceptionCl�Introuvable {
		int h = Math.abs(c.hashCode() % CAPCT);
		if (this.donn�es[h] == null) throw new ExceptionCl�Introuvable(c);
		return this.donn�es[h].value;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < donn�es.length; i++) {
			String ligne = "";
			if (this.donn�es[i] != null) ligne = this.donn�es[i].toString();
			str += String.format("%s - %s\n", i, ligne);
		}
		return str;
	}

}