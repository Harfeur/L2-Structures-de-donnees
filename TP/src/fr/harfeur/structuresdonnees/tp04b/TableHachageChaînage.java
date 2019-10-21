package fr.harfeur.structuresdonnees.tp04b;

public class TableHachageCha�nage<Cl�, Valeur> implements Dictionnaire<Cl�, Valeur> {
	
	private Maillon<Cl�,Valeur>[] donn�es;
	private static int CAPCT = 15;

	@SuppressWarnings("unchecked")
	public TableHachageCha�nage() {
		super();
		this.donn�es = new Maillon[CAPCT];
	}
	
	@Override
	public void ajouter(Cl� c, Valeur v) throws ExceptionCl�D�j�Existante, ExceptionDicoPlein {
		int h = Math.abs(c.hashCode() % CAPCT);
		if (this.donn�es[h] == null) this.donn�es[h] = new Maillon<Cl�, Valeur>(c,v);
		else {
			Maillon<Cl�, Valeur> m = this.donn�es[h];
			while (m.successeur != null) {
				if (m.key == c) throw new ExceptionCl�D�j�Existante(c);
				m = m.successeur;
			}
			if (m.key == c) throw new ExceptionCl�D�j�Existante(c);
			m.successeur = new Maillon<Cl�, Valeur>(c, v);
		}
	}

	@Override
	public void supprimer(Cl� c) {
		int h = Math.abs(c.hashCode() % CAPCT);
		if (this.donn�es[h] == null) return;
		Maillon<Cl�, Valeur> m = this.donn�es[h];
		if (m.key == c) this.donn�es[h] = m.successeur;
		else {
			while (m.successeur != null) {
				if (m.successeur.key == c) {
					m.successeur = m.successeur.successeur;
					return;
				}
				m = m.successeur;
			}
		}
	}

	@Override
	public boolean estPr�sent(Cl� c) {
		int h = Math.abs(c.hashCode() % CAPCT);
		if (this.donn�es[h] == null) return false;
		Maillon<Cl�, Valeur> m = this.donn�es[h];
		if (m.key == c) return true;
		while (m.successeur != null) {
			if (m.successeur.key == c) return true;
		}
		return false;
	}

	@Override
	public Valeur rechercher(Cl� c) throws ExceptionCl�Introuvable {
		int h = Math.abs(c.hashCode() % CAPCT);
		if (this.donn�es[h] == null) throw new ExceptionCl�Introuvable(c);
		Maillon<Cl�, Valeur> m = this.donn�es[h];
		if (m.key == c) return m.value;
		while (m.successeur != null) {
			if (m.successeur.key == c) return m.successeur.value;
			m = m.successeur;
		}
		throw new ExceptionCl�Introuvable(c);
	}

}
