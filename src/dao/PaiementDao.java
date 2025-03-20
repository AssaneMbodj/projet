package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import model.Paiement;

public class PaiementDao extends ConnectionDao {
    
    public PaiementDao() {
        super();
    }

    public int add(Paiement paiement) {
        Connection con = null;
        PreparedStatement ps = null;
        int returnValue = 0;
        
        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("INSERT INTO Paiement (idPaiement, idLoc, idBien, montant, datePaiement, valide) VALUES(?, ?, ?, ?, ?, ?)");
            ps.setInt(1, paiement.getIdPaiement());
            ps.setInt(2, paiement.getIdLoc());
            ps.setInt(3, paiement.getIdBien());
            ps.setDouble(4, paiement.getMontant());
            ps.setDate(5, new java.sql.Date(paiement.getDatePaiement().getTime()));
            ps.setBoolean(6, paiement.isValide());

            returnValue = ps.executeUpdate();

        } catch (Exception e) {
            if (e.getMessage().contains("ORA-00001"))
                System.out.println("Cet identifiant de paiement existe déjà. Ajout impossible !");
            else
                e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ignore) {}
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception ignore) {}
        }
        return returnValue;
    }

    public int update(Paiement paiement) {
        Connection con = null;
        PreparedStatement ps = null;
        int returnValue = 0;
        
        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("UPDATE Paiement set idLoc = ?, idBien = ?, montant = ?, datePaiement = ?, valide = ? WHERE idPaiement = ?");
            ps.setInt(1, paiement.getIdLoc());
            ps.setInt(2, paiement.getIdBien());
            ps.setDouble(3, paiement.getMontant());
            ps.setDate(4, new java.sql.Date(paiement.getDatePaiement().getTime()));
            ps.setBoolean(5, paiement.isValide());
            ps.setInt(6, paiement.getIdPaiement());

            returnValue = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ignore) {}
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception ignore) {}
        }
        return returnValue;
    }

    public int delete(int idPaiement) {
        Connection con = null;
        PreparedStatement ps = null;
        int returnValue = 0;
        
        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("DELETE FROM Paiement WHERE idPaiement = ?");
            ps.setInt(1, idPaiement);

            returnValue = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ignore) {}
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception ignore) {}
        }
        return returnValue;
    }

    public Paiement get(int idPaiement) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Paiement returnValue = null;
        
        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("SELECT * FROM Paiement WHERE idPaiement = ?");
            ps.setInt(1, idPaiement);
            rs = ps.executeQuery();
            if (rs.next()) {
                returnValue = new Paiement(
                    rs.getInt("idPaiement"),
                    rs.getInt("idLoc"),
                    rs.getInt("idBien"),
                    rs.getDouble("montant"),
                    rs.getDate("datePaiement"),
                    rs.getBoolean("valide")
                );
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ignore) {}
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ignore) {}
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception ignore) {}
        }
        return returnValue;
    }

    public ArrayList<Paiement> getList() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Paiement> returnValue = new ArrayList<Paiement>();
        
        try {
            con = DriverManager.getConnection(URL, LOGIN, PASS);
            ps = con.prepareStatement("SELECT * FROM Paiement ORDER BY idPaiement");
            rs = ps.executeQuery();
            while (rs.next()) {
                returnValue.add(new Paiement(
                    rs.getInt("idPaiement"),
                    rs.getInt("idLoc"),
                    rs.getInt("idBien"),
                    rs.getDouble("montant"),
                    rs.getDate("datePaiement"),
                    rs.getBoolean("valide")
                ));
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ignore) {}
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ignore) {}
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception ignore) {}
        }
        return returnValue;
    }

	public void add1(Paiement newPaiement) {
		// TODO Auto-generated method stub
		
	}
}
