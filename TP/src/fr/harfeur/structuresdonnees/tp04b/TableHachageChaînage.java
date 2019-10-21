package fr.harfeur.structuresdonnees.tp04b;

public class TableHachageChaînage<Clé, Valeur> implements Dictionnaire<Clé, Valeur> {
	
	private Maillon<Clé,Valeur>[] données;
	private static int CAPCT = 15;

	@SuppressWarnings("unchecked")
	public TableHachageChaînage() {
		super();
		this.données = new Maillon[CAPCT];
	}
	
	@Override
	public void ajouter(Clé c, Valeur v) throws ExceptionCléDéjàExistante, ExceptionDicoPlein {
		int h = Math.abs(c.hashCode() % CAPCT);
		if (this.données[h] == null) this.données[h] = new Maillon<Clé, Valeur>(c,v);
		else {
			Maillon<Clé, Valeur> m = this.données[h];
			while (m.successeur != null) {
				if (m.key == c) throw new ExceptionCléDéjàExistante(c);
				m = m.successeur;
			}
			if (m.key == c) throw new ExceptionCléDéjàExistante(c);
			m.successeur = new Maillon<Clé, Valeur>(c, v);
		}
	}

	@Override
	public void supprimer(Clé c) {
		int h = Math.abs(c.hashCode() % CAPCT);
		if (this.données[h] == null) return;
		Maillon<Clé, Valeur> m = this.données[h];
		if (m.key == c) this.données[h] = m.successeur;
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
	public boolean estPrésent(Clé c) {
		int h = Math.abs(c.hashCode() % CAPCT);
		if (this.données[h] == null) return false;
		Maillon<Clé, Valeur> m = this.données[h];
		if (m.key == c) return true;
		while (m.successeur != null) {
			if (m.successeur.key == c) return true;
		}
		return false;
	}

	@Override
	public Valeur rechercher(Clé c) throws ExceptionCléIntrouvable {
		int h = Math.abs(c.hashCode() % CAPCT);
		if (this.données[h] == null) throw new ExceptionCléIntrouvable(c);
		Maillon<Clé, Valeur> m = this.données[h];
		if (m.key == c) return m.value;
		while (m.successeur != null) {
			if (m.successeur.key == c) return m.successeur.value;
			m = m.successeur;
		}
		throw new ExceptionCléIntrouvable(c);
	}

}
