package formation.afpaStream;

import java.io.Serializable;

public class Voiture implements Serializable { // permet de 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String marque;
	private int annee;
	private String modele;
	
	
	
	public Voiture(String marque, String modele, int annee ) {
		super();
		this.marque = marque;
		this.annee = annee;
		this.modele = modele;
	}

	public Voiture() {

	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}
	

}
