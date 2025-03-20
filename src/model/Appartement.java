package model;

public class Appartement {
     private String app_id;
     private String app_adresse;
     private int nombrePieces;
     private String app_meuble;
     private String anneeConst;
     private int escalier;
     private int etage;
     private String numeroAppartement;
	public Appartement(String app_id, String app_adresse, int nombrePieces, String app_meuble, String anneeConst,
			int escalier, int etage, String numeroAppartement) {
		super();
		this.app_id = app_id;
		this.app_adresse = app_adresse;
		this.nombrePieces = nombrePieces;
		this.app_meuble = app_meuble;
		this.anneeConst = anneeConst;
		this.escalier = escalier;
		this.etage = etage;
		this.numeroAppartement = numeroAppartement;
	}
	public String getApp_id() {
		return app_id;
	}
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}
	public String getApp_adresse() {
		return app_adresse;
	}
	public void setApp_adresse(String app_adresse) {
		this.app_adresse = app_adresse;
	}
	public int getNombrePieces() {
		return nombrePieces;
	}
	public void setNombrePieces(int nombrePieces) {
		this.nombrePieces = nombrePieces;
	}
	public String getApp_meuble() {
		return app_meuble;
	}
	public void setApp_meuble(String app_meuble) {
		this.app_meuble = app_meuble;
	}
	public String getAnneeConst() {
		return anneeConst;
	}
	public void setAnneeConst(String anneeConst) {
		this.anneeConst = anneeConst;
	}
	public int getEscalier() {
		return escalier;
	}
	public void setEscalier(int escalier) {
		this.escalier = escalier;
	}
	public int getEtage() {
		return etage;
	}
	public void setEtage(int etage) {
		this.etage = etage;
	}
	public String getNumeroAppartement() {
		return numeroAppartement;
	}
	public void setNumeroAppartement(String numeroAppartement) {
		this.numeroAppartement = numeroAppartement;
	}
    
}
