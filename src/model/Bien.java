package model;


import java.util.ArrayList;

public class Bien  {
	
	
	private String adresse;
	private String type;
	private int anneeConst;
	private int idBien;

	/**
	 * @param  adresse
	 * @param type
	 * @param annéeConst
	 * @param idBien
	 */
	public Bien (String adresse, String type, int annéeConst, int idBien) {
		super();
		this.adresse = adresse;
		this.type = type;
		this.anneeConst = annéeConst;
		this.idBien = idBien;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAnneeConst() {
		return anneeConst;
	}

	public void setAnneeConst(int annéeConst) {
		this.anneeConst = annéeConst;
	}

	public int getIdBien() {
		return idBien;
	}

	public void setIdBien(int idBien) {
		this.idBien = idBien;
	}
	
	
}