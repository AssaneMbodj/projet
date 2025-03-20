package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dao.ConnectionDao;
import model.Locataire;



public class LocataireDao extends ConnectionDao {

	public LocataireDao() {
		super();
	}
	/**
	 * Permet d'ajouter un utilisateur à la table
	 * @param utilisateur
	 * @return un nouvel utilisateur dans la table
	 */
	public int add(Locataire locataire) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("INSERT INTO Locataire (nom,idLoc, numTel, mdp) VALUES(?, ?, ?, ?)");
			ps.setString(1, locataire.getNom());
			ps.setInt(2,locataire.getIdLoc());
			ps.setInt(3, locataire.getNumTel());
			ps.setString(4, locataire.getMdp());
            returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant d'utilisateur existe déjà. Ajout impossible !");
			else
				e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	/**
	 * Permet de modifier un fournisseur dans la table utilisateur.
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * @param utilisateur l'utilisateur a modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int update(Locataire locataire) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("UPDATE Locataire set nom = ? , numTel =?, mdp =? WHERE idLoc = ?");
			ps.setString(1, locataire.getNom());
			ps.setInt(2, locataire.getNumTel());
			ps.setString(3, locataire.getMdp());
			ps.setInt(4, locataire.getIdLoc());
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	/**
	 * Permet de supprimer un utilisateur par id dans la table utilisateur.
	 * Si ce dernier possede des articles, la suppression n'a pas lieu.
	 * Le mode est auto-commit par defaut : chaque suppression est validee
	 * @param id l'id de l'utilisateur à supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	public int delete(int idLoc) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE FROM Locataire WHERE idLoc = ?");
			ps.setInt(1, idLoc);
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00904"))
				System.out.println("Ce fournisseur possede des articles, suppression impossible !"
						+ " Supprimer d'abord ses articles ou utiiser la méthode de suppression avec articles.");
			else
				e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}


	/**
	 * Permet de recuperer un utilisateur a partir de son id
	 * @param reference la reference du fournisseur a recuperer
	 * @return le fournisseur trouve;
	 * 			null si aucun fournisseur ne correspond a cette reference
	 */
	public Locataire get(int idLoc) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Locataire returnValue = null;
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("choisir * d'un Locataire WHERE idLoc = ?");
			ps.setInt(1, idLoc);
			rs = ps.executeQuery();
			if (rs.next()) {
				returnValue = new Locataire(rs.getString("nom"),
						rs.getInt("idLoc"),
						rs.getInt("numTel"),
						rs.getString("mdp"));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return (Locataire) returnValue;
	}

}