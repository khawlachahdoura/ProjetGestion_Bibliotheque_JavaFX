package ImpDAO1;

import java.sql.*;

import Business.mySingleton;
import Entities.Exemplaire;
import Entities.Livre;
import IserviceDAO.IDAOGererLivre;

public class ImpDAOGererLivre implements IDAOGererLivre {
	private PreparedStatement inserLivre = null;
	private static Statement ps = null;

	private static ResultSet rs = null;
	private mySingleton mySing = mySingleton.getInstance();

	private Connection conn = mySing.getConnection();

	@Override
	public boolean ajouter(Livre livre) {

		try {

			inserLivre = conn.prepareStatement("INSERT INTO `livre`  VALUES ( ?, ?, ?, ?)");

			inserLivre.setInt(1, livre.getISBN());

			inserLivre.setString(2, livre.getTitre());
			inserLivre.setString(3, livre.getTheme());

			inserLivre.setString(4, livre.getAuteur());

			inserLivre.executeUpdate();
			return true;
		}

		catch (SQLException e) {

			System.out.println("add livre :" + e.getMessage());

		}

		return false;

	}
	public boolean ajouterexemplaire(Exemplaire livre ) {

		try {

			inserLivre = conn.prepareStatement("INSERT INTO `exemplaire` (`idExemplaire`, `ISBN`, `Titre`, `Theme`, `Auteur`, `code`)  VALUES ( NULL , ?, ?, ?, ?, ? )");

			inserLivre.setInt(1, livre.getISBN());

			inserLivre.setString(2, livre.getTitre());
			inserLivre.setString(3, livre.getTheme());

			inserLivre.setString(4, livre.getAuteur());
			inserLivre.setInt(5, livre.getCodeExemplaire());
			inserLivre.executeUpdate();
			return true;
		}

		catch (SQLException e) {

			System.out.println("add exemplaire :" + e.getMessage());

		}

		return false;

	}
	
	/*private Livre rechercheLivre(String nom) {
		Livre livre= new Livre(0, null, null, null);
		String requete = "SELECT * FROM livre  WHERE livre.`titre` = " + nom;
	
		
		try {
		  
			ps = conn.createStatement();
			rs = ps.executeQuery(requete);
			int isbn=0;
			while (rs.next()) {
				 isbn = rs.getInt("ISBN");
			//isbn++;

			}
			if(isbn!=0) {
				String requete1 = "SELECT ISBN FROM exemplaire  WHERE exemplaire.`ISBN` = " + isbn;
				
				ps = conn.createStatement();
				rs = ps.executeQuery(requete1);
				while (rs.next()) {

					
				}
				//System.out.println(nbreExemplaire+ " " +  idExemplaire);
			} else {
				System.out.println("il n' y pas un livre avec cette ISBN ");
			}
				
				 
			 		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return  livre;
		
	}*/

	@Override
	public boolean supprimer(int isbn) {
		try {

			inserLivre = conn.prepareStatement("DELETE FROM `livre` WHERE `livre`.`ISBN` = ?");

			inserLivre.setInt(1, isbn);

			inserLivre.executeUpdate();
			return true;
		}

		catch (SQLException e) {

			System.out.println("Delete :" + e.getMessage());

		}

		return false;
	}

	@Override
	public boolean updateISBN(int nisbn, int aISBN) {
		try {

			inserLivre = conn.prepareStatement("UPDATE `livre` SET `isbn` = ? WHERE `livre`.`ISBN` = ?");

			inserLivre.setInt(1, nisbn);
			inserLivre.setInt(2, aISBN);

			inserLivre.executeUpdate();
			return true;
		}

		catch (SQLException e) {

			System.out.println("update :" + e.getMessage());

		}

		return false;
	}

	@Override
	public boolean updateTitre(String titre, int aISBN) {
		try {

			inserLivre = conn.prepareStatement("UPDATE `livre` SET `titre` = ? WHERE `livre`.`ISBN` = ?");

			inserLivre.setString(1, titre);
			inserLivre.setInt(2, aISBN);

			inserLivre.executeUpdate();
			return true;
		}

		catch (SQLException e) {

			System.out.println("update :" + e.getMessage());

		}

		return false;
	}

	@Override
	public boolean updateTheme(String theme, int aISBN) {
		try {

			inserLivre = conn.prepareStatement("UPDATE `livre` SET `theme` = ? WHERE `livre`.`ISBN` = ?");

			inserLivre.setString(1, theme);
			inserLivre.setInt(2, aISBN);

			inserLivre.executeUpdate();
			return true;
		}

		catch (SQLException e) {

			System.out.println("update :" + e.getMessage());

		}

		return false;
	}

	@Override
	public boolean updateAuteur(String auteur, int aISBN) {
		try {

			inserLivre = conn.prepareStatement("UPDATE `livre` SET `auteur` = ? WHERE `livre`.`ISBN` = ?");

			inserLivre.setString(1, auteur);
			inserLivre.setInt(2, aISBN);

			inserLivre.executeUpdate();
			return true;
		}

		catch (SQLException e) {

			System.out.println("update :" + e.getMessage());

		}

		return false;
	}

}
