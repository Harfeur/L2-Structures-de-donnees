package fr.harfeur.structuresdonnees.tp04b;

public class TableHachageSondage<Cl�, Valeur> implements Dictionnaire<Cl�, Valeur> {

	private Couple<Cl�,Valeur>[] donn�es;
	private static int CAPCT = 15;
	
	@SuppressWarnings("unchecked")
	public TableHachageSondage() {
		super();
		this.donn�es = new Couple[CAPCT];
	}
	
	@Override
	public void ajouter(Cl� c, Valeur v) throws ExceptionCl�D�j�Existante, ExceptionDicoPlein {
		int h = Math.abs(c.hashCode() % CAPCT);
		Couple<Cl�, Valeur> couple = new Couple<Cl�, Valeur>(c, v);
		int i = h;
		while (this.donn�es[i] != null && this.donn�es[i].del) {
			i = (i+1) % CAPCT;
			if (i == h) throw new ExceptionDicoPlein();
			if (this.donn�es[i] != null && this.donn�es[i].key == c) throw new ExceptionCl�D�j�Existante(c);
		}
		this.donn�es[i] = couple;
	}

	@Override
	public void supprimer(Cl� c) {
		int h = Math.abs(c.hashCode() % CAPCT);
		int i = h;
		do {
			if (this.donn�es[i] != null && this.donn�es[i].key == c) {
				this.donn�es[i].del = true;
				return;
			}
			i = (i+1) % CAPCT;
		} while (h != i);
	}

	@Override
	public boolean estPr�sent(Cl� c) {
		int h = Math.abs(c.hashCode() % CAPCT);
		int i = h;
		while (this.donn�es[i] != null) {
			if (this.donn�es[i].key == c) return true;
			i = (i+1) % CAPCT;
			if (i == h) return false;
		}
		return false;
	}

	@Override
	public Valeur rechercher(Cl� c) throws ExceptionCl�Introuvable {
		int h = Math.abs(c.hashCode() % CAPCT);
		int i = h;
		while (this.donn�es[i] != null) {
			if (this.donn�es[i].key == c) return this.donn�es[i].value;
			i++;
			if (i == h) throw new ExceptionCl�Introuvable(c);
		}
		throw new ExceptionCl�Introuvable(c);
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