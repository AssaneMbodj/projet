package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.ConnectionDao;
import model.Bien;



public class BienDao extends ConnectionDao {

	public BienDao() {
		super();
	}
	/**
	 * Permet d'ajouter un utilisateur à la table
	 * @param utilisateur
	 * @return un nouvel utilisateur dans la table
	 */
	public int add(Bien bien) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("INSERT INTO Bien (adresse,type,anneeConst,idBien) VALUES(?, ?, ?, ?)");
			ps.setString(1,  bien.getAdresse());
			ps.setString(2, bien.getType());
			ps.setInt(3,  bien.getAnneeConst());
			ps.setInt(4,  bien.getIdBien());

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
	public int update(Bien bien) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("UPDATE Bien set adresse = ? , type =?, anneeConst =? WHERE idBien = ?");
			ps.setString(1, bien.getAdresse());
			ps.setString(2, bien.getType());
			ps.setInt(3,  bien.getAnneeConst());
			ps.setInt(4,  bien.getIdBien());

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
	
	public int delete(int idBien) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("DELETE FROM Bien WHERE idBien = ?");
			ps.setInt(1, idBien);

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
	public Bien get(int idBien) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Bien returnValue = null;
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("choisir * d'un Bien WHERE idBien = ?");
			ps.setInt(1, idBien);
			rs = ps.executeQuery();
			if (rs.next()) {
				returnValue = new Bien(rs.getString("adresse"),
						rs.getString("type"),
						rs.getInt("idBien"),
						rs.getInt("anneeConst"));
				        
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
		return (Bien) returnValue;
	}
	/**
	 * Permet de recuperer tous les biens stockes dans la table Bien
	 * 
	 * @return une ArrayList de cours
	 */
	public ArrayList<Bien> getList() {
		
		ArrayList<Bien> biens = new ArrayList<>();
        biens.add(new Bien("Maison", "Paris", 12,2024));
        biens.add(new Bien("Appartement", "Lyon", 8,2025));
        // Ajoutez votre logique de base de données ici
        return biens;
        /*
         * 
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Bien> returnValue = new ArrayList<Bien>();
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Bien ORDER BY idBien");
			rs = ps.executeQuery();
			while (rs.next()) {
				returnValue.add(new Bien(rs.getString("adresse"),rs.getString("type"),rs.getInt("idBien"),rs.getInt("anneeConst")));
						
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}*/
}
}



