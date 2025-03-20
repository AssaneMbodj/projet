package model;


import java.util.ArrayList;

public class Locataire  {

	private int numTel;
	private String nom;
	private String mdp;
	private int idLoc;
	private int age;
	private int lct_rib;
	
	

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

	public Locataire (String nom,int idLoc,int numTel, String mdp) {
		        this.nom=nom;
				this.mdp=mdp;
				this.numTel=numTel;
				this.idLoc= idLoc;
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

		public String getNom () {
		return nom;
	}

		public int getIdLoc () {
		return idLoc;
	}

	/**
	 * Setter de l'attribut numTel
	 * @param numTel
	 */

	public void setNumTel (int numTel) {
		this.numTel = numTel;
	}

	public void setIdLoc (int idLoc) {
		
		
		this.idLoc= idLoc;
	}

	public void setNom (String nom) {
		this.nom=nom;
	}

	public void setMdp (String mdp) {
		this.mdp=mdp;
	}
	
	

}

