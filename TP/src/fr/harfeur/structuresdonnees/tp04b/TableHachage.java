package fr.harfeur.structuresdonnees.tp04b;

public class TableHachage<Clé, Valeur> implements Dictionnaire<Clé, Valeur> {

	private Couple<Clé,Valeur>[] données;
	private static int CAPCT = 15;
	
	@SuppressWarnings("unchecked")
	public TableHachage() {
		super();
		this.données = new Couple[CAPCT];
	}
	
	@Override
	public void ajouter(Clé c, Valeur v) throws ExceptionCléDéjàExistante {
		int h = Math.abs(c.hashCode() % CAPCT);
		if (this.données[h] != null) throw new ExceptionCléDéjàExistante(c);
		Couple<Clé, Valeur> couple = new Couple<Clé, Valeur>(c, v);
		this.données[h] = couple;
	}

	@Override
	public void supprimer(Clé c) {
		int h = Math.abs(c.hashCode() % CAPCT);
		this.données[h] = null;
	}

	@Override
	public boolean estPrésent(Clé c) {
		int h = Math.abs(c.hashCode() % CAPCT);
		if (this.données[h] == null) return false;
		return this.données[h].key == c;
	}

	@Override
	public Valeur rechercher(Clé c) throws ExceptionCléIntrouvable {
		int h = Math.abs(c.hashCode() % CAPCT);
		if (this.données[h] == null) throw new ExceptionCléIntrouvable(c);
		return this.données[h].value;
	}
	
	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < données.length; i++) {
			String ligne = "";
			if (this.données[i] != null) ligne = this.données[i].toString();
			str += String.format("%s - %s\n", i, ligne);
		}
		return str;
	}

}