package model;

import java.util.Date;

public class Paiement {
    private int idPaiement;
    private int idLoc;
    private int idBien;
    private double montant;
    private Date datePaiement;
    private boolean valide;
    
    public Paiement(int idPaiement, int idLoc, int idBien, double montant, Date datePaiement, boolean valide) {
        this.idPaiement = idPaiement;
        this.idLoc = idLoc;
        this.idBien = idBien;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.valide = valide;
    }

    public Paiement(int idPaiement2, int idLoc2, int idBien2, double montant2, java.sql.Date datePaiement2,
			boolean valide2) {
		// TODO Auto-generated constructor stub
	}

	public int getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(int idPaiement) {
        this.idPaiement = idPaiement;
    }

    public int getIdLoc() {
        return idLoc;
    }

    public void setIdLoc(int idLoc) {
        this.idLoc = idLoc;
    }

    public int getIdBien() {
        return idBien;
    }

    public void setIdBien(int idBien) {
        this.idBien = idBien;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }
}
