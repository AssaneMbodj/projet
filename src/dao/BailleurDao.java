package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.ConnectionDao;
import model.Bailleur;




public class BailleurDao extends ConnectionDao {

	public BailleurDao() {
		super();
	}
	/**
	 * Permet d'ajouter un utilisateur à la table
	 * @param utilisateur
	 * @return un nouvel utilisateur dans la table
	 */
	public int add(Bailleur bailleur ) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("INSERT INTO Bailleur (nomBail,idBail, numTel, mdp) VALUES(?, ?, ?, ?)");
			ps.setString(1, bailleur.getNomBail());
			ps.setInt(2,bailleur.getIdBail());
			ps.setInt(3, bailleur.getNumTel());
			ps.setString(4, bailleur.getMdp());

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
	public int update(Bailleur bailleur) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("UPDATE Bailleur set nomBail = ? , numTel =?, mdp =? WHERE idBail = ?");
			ps.setString(1, bailleur.getNomBail());
			ps.setInt(2, bailleur.getNumTel());
			ps.setString(3, bailleur.getMdp());
			ps.setInt(4, bailleur.getIdBail());
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
	public int delete(int idBail) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE FROM Bailleur WHERE idBail = ?");
			ps.setInt(1, idBail);

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
	public Bailleur get(int idBail) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
Bailleur returnValue = null;
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("choisir * d'un Bailleur WHERE idBail = ?");
			ps.setInt(1, idBail);
			rs = ps.executeQuery();
			if (rs.next()) {
				returnValue = new Bailleur(rs.getString("nomBail"),
						rs.getInt("idBail"),
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
		return (Bailleur) returnValue;
	}

}