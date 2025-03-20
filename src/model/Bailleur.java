package model;


import java.util.ArrayList;

public class Bailleur  {

	private int numTel;
	private String nomBail;
	private String mdp;
	private int idBail;
	

	/**
	 * /*
	 * Fonction permettant de construire un enseignant en héritant de utilisateur les attributs suivant :
	 * @param nom
	 * @param prenom
	 * @param id
	 * @param password
	 * 
	 * Pour cette classe on ajoutera également l'attribut
	 * @param numTel
	 */

	public Bailleur ( String nomBail, int idBail,int numTel, String mdp) {
		        this.nomBail=nomBail;
				this.mdp=mdp;
				this.numTel=numTel;
				this.idBail= idBail;
	}

	/**
	 * Getter de l'attribut numTel
	 * @return le numéro de téléphone d'un enseignant
	 */

		public int getNumTel () {
		return numTel;
	}

		public String getMdp () {
		return mdp;
	}

		public int getIdBail () {
		return idBail;
	}

	/**
	 * Setter de l'attribut numTel
	 * @param numTel
	 */

	public void setNumTel (int numTel) {
		this.numTel = numTel;
	}

	public void setIdBail (int idBail) {
		
		
		this.idBail= idBail;
	}

	public void setNom (String nomBail) {
		this.nomBail=nomBail;
	}

	public void setMdp (String mdp) {
		this.mdp=mdp;
	}

	public String getNomBail() {
	
		return nomBail;
	}
	
	

}

