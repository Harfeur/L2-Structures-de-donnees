package fr.harfeur.structuresdonnees.tp01;

public class ListeContigue<E> implements Liste<E> {

	static int CAPCT = 5;
	
	Object[] valeurs;
	
	int taille;
	
	
	
	
	public ListeContigue(int capct) {
		super();
		this.valeurs = new Object[5];
		this.taille = 0;
	}

	@Override
	public int longueur() {
		return this.taille;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E ieme(int indice) throws ExceptionIndiceHorsLimites {
		if (indice >= 0 && indice < this.taille)
			return (E) this.valeurs[indice];
		else
			throw new ExceptionIndiceHorsLimites(indice);
	}

	@Override
	public void inserer(int indice, E element) throws ExceptionIndiceHorsLimites {
		if (indice >= 0 && indice <= this.taille) {
			int j = this.taille;
			while (j > indice) {
				this.valeurs[j] = this.valeurs[j-1];
				j--;
			}
			this.valeurs[indice] = element;
			this.taille++;
		}
		else
			throw new ExceptionIndiceHorsLimites(indice);
	}

	@Override
	public void supprimer(int indice) throws ExceptionIndiceHorsLimites {
		if (indice >= 0 && indice < this.taille) {
			int j = indice;
			while (j < this.taille - 1) {
				this.valeurs[j] = this.valeurs[j+1];
				j++;
			}
			this.taille--;
		}
		else
			throw new ExceptionIndiceHorsLimites(indice);
	}
	
	@Override
	public String toString() {
		switch (this.taille) {
		case 0:
			return "[ ]";

		case 1:
			return String.format("[ %s ]", this.valeurs[0]);
			
		default:
			String str = "[ ";
			int i = 0;
			while (i < this.taille - 1) {
				str += this.valeurs[i] + ", ";
				i++;
			}
			return str + this.valeurs[i] + " ]";
		}
	}

}
