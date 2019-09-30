package fr.harfeur.structuresdonnees.tp02;

public class PileContigue<E> implements Pile<E> {

	private Object[] valeurs;
	private int psommet;
	
	private static int CAPCT = 10;
	
	public PileContigue() {
		super();
		this.valeurs = new Object[CAPCT];
		this.psommet = -1;
	}
	
	@Override
	public boolean estVide() {
		return this.psommet == -1;
	}

	@Override
	public void empiler(E e) {
		this.psommet++;
		this.valeurs[this.psommet] = e;
	}

	@Override
	public void depiler() throws ExceptionPileVide {
		if (this.psommet == -1) throw new ExceptionPileVide();
		this.psommet--;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E sommet() throws ExceptionPileVide {
		if (this.psommet == -1) throw new ExceptionPileVide();
		return (E) this.valeurs[this.psommet];
	}

}
