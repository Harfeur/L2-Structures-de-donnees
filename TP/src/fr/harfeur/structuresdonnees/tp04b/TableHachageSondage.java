package fr.harfeur.structuresdonnees.tp04b;

public class TableHachageSondage<Clé, Valeur> implements Dictionnaire<Clé, Valeur> {

	private Couple<Clé,Valeur>[] données;
	private static int CAPCT = 15;
	
	@SuppressWarnings("unchecked")
	public TableHachageSondage() {
		super();
		this.données = new Couple[CAPCT];
	}
	
	@Override
	public void ajouter(Clé c, Valeur v) throws ExceptionCléDéjàExistante, ExceptionDicoPlein {
		int h = Math.abs(c.hashCode() % CAPCT);
		Couple<Clé, Valeur> couple = new Couple<Clé, Valeur>(c, v);
		int i = h;
		while (this.données[i] != null && this.données[i].del) {
			i = (i+1) % CAPCT;
			if (i == h) throw new ExceptionDicoPlein();
			if (this.données[i] != null && this.données[i].key == c) throw new ExceptionCléDéjàExistante(c);
		}
		this.données[i] = couple;
	}

	@Override
	public void supprimer(Clé c) {
		int h = Math.abs(c.hashCode() % CAPCT);
		int i = h;
		do {
			if (this.données[i] != null && this.données[i].key == c) {
				this.données[i].del = true;
				return;
			}
			i = (i+1) % CAPCT;
		} while (h != i);
	}

	@Override
	public boolean estPrésent(Clé c) {
		int h = Math.abs(c.hashCode() % CAPCT);
		int i = h;
		while (this.données[i] != null) {
			if (this.données[i].key == c) return true;
			i = (i+1) % CAPCT;
			if (i == h) return false;
		}
		return false;
	}

	@Override
	public Valeur rechercher(Clé c) throws ExceptionCléIntrouvable {
		int h = Math.abs(c.hashCode() % CAPCT);
		int i = h;
		while (this.données[i] != null) {
			if (this.données[i].key == c) return this.données[i].value;
			i++;
			if (i == h) throw new ExceptionCléIntrouvable(c);
		}
		throw new ExceptionCléIntrouvable(c);
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