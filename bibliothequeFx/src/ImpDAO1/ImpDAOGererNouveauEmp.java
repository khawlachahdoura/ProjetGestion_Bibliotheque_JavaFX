package ImpDAO1;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

import Business.mySingleton;
import Entities.Emprunt;
import Entities.Etudiant;
import Entities.Livre;
import IserviceDAO.IDAOGererNouveauEmp;

public class ImpDAOGererNouveauEmp implements IDAOGererNouveauEmp {

	private PreparedStatement inserEmprunt = null;
	private static Statement ps = null;
	private int nbreExemplaireDispo=0;

	private static ResultSet rs = null;
	private static mySingleton mySing = mySingleton.getInstance();

	private static Connection conn = mySing.getConnection();
	
	public static ArrayList affichelist1() {
		ArrayList<Etudiant> etudiant =new ArrayList();
		//Connection conn= myConn();
		Statement ps= null;
		ResultSet rs = null;
		String serveurBD="jdbc:mysql://127.0.0.1:3306/bibliotheque?autoReconnect=true&useSSL=false";
		String login="root";
		String motPasse="";
		try {
			
			String requete="select * from etudiant";
			Statement pStatement =(PreparedStatement)conn.prepareStatement(requete);
			ps = (Statement) conn.createStatement();
			 rs = pStatement.executeQuery(requete);
			while (rs.next()) {
				int idEtudiant=(int) rs.getLong("idEtudiant");
				int codeEtudiant= (int) rs.getLong("codeEtudiant");
				 String nom = rs.getString("nom");
				 String prenom = rs.getString("prenom");
				 String groupe=rs.getString("groupe");
				
				Etudiant E1 = new Etudiant(idEtudiant,codeEtudiant,nom,prenom,groupe);
				etudiant.add(E1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
		}
		
		return etudiant;
	}
	
	public static ArrayList affichelist2() {
		ArrayList<Emprunt> emprunts =new ArrayList();
		//Connection conn= myConn();
		Statement ps= null;
		ResultSet rs = null;
		String serveurBD="jdbc:mysql://127.0.0.1:3306/bibliotheque?autoReconnect=true&useSSL=false";
		String login="root";
		String motPasse="";
		try {
			
			String requete="select * from emprunt";
			Statement pStatement =(PreparedStatement)conn.prepareStatement(requete);
			ps = (Statement) conn.createStatement();
			 rs = pStatement.executeQuery(requete);
			while (rs.next()) {
				int codeEtudiant= (int) rs.getLong("idEmpt");
				
				 Date DateEmprunt = rs.getDate("DateEmprunt");
				 Date DateRetour = rs.getDate("DateRetour");
				 int idExemplaire= (int) rs.getLong("idExemplaire");
				 int idEtudiant= (int) rs.getLong("idEtudiant");
				 int etat= (int) rs.getLong("etat");
				 
				Emprunt E1 = new Emprunt(codeEtudiant,idExemplaire,idEtudiant,DateEmprunt,DateRetour,etat);
				emprunts.add(E1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
		}
		
		return emprunts;
	}
	
	public static ArrayList affichelist3() {
		ArrayList<Livre> emprunts =new ArrayList();
		//Connection conn= myConn();
		Statement ps= null;
		ResultSet rs = null;
		String serveurBD="jdbc:mysql://127.0.0.1:3306/bibliotheque?autoReconnect=true&useSSL=false";
		String login="root";
		String motPasse="";
		try {
			
			String requete="select * from livre";
			Statement pStatement =(PreparedStatement)conn.prepareStatement(requete);
			ps = (Statement) conn.createStatement();
			 rs = pStatement.executeQuery(requete);
			while (rs.next()) {
				int ISBN= (int) rs.getLong("ISBN");
				 String DateEmprunt = rs.getString("Titre");
				 String DateRetour = rs.getString("Theme");
				 String Auteur=  rs.getString("Auteur");
				
				
				Livre E1 = new Livre(ISBN,DateEmprunt,DateRetour,Auteur);
				emprunts.add(E1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Execption");
		}
		
		return emprunts;
	}
	
	
	
	
	
	
	
/*
	@Override
	public boolean ajouter(Emprunt emprunt) {
		try {

			inserEmprunt = conn.prepareStatement("INSERT INTO `emprunt` VALUES (NULL, ?, ?, ?, ?)");

			inserEmprunt.setDate(1, emprunt.getDate_E());

			inserEmprunt.setDate(2, emprunt.getDate_RE());
			inserEmprunt.setInt(3, emprunt.getIdExemplaire());

			inserEmprunt.setInt(4, emprunt.getIdEtudiant());

			inserEmprunt.executeUpdate();
			return true;
		}

		catch (SQLException e) {

			System.out.println("add emprunt :" + e.getMessage());

		}

		return false;

	}***/
	@Override
	public boolean ajouter(Emprunt emprunt) {
		try {
			
			nbreExemplaireDispo=	calculerNbreExemplaire(emprunt.getIdExemplaire());
			
			 

			if(nbreExemplaireDispo==0) {
				System.out.println(" il n' y pas un exemplaire pour ce livre pour l'emprunte ");
			}else {
				if(nbreExemplaireDispo >0) {
				inserEmprunt = conn.prepareStatement("INSERT INTO emprunt VALUES (NULL, ?, ?, ?, ?,?)");

				inserEmprunt.setDate(1, emprunt.getDate_E());

				inserEmprunt.setDate(2, emprunt.getDate_RE());
				inserEmprunt.setInt(3, emprunt.getIdExemplaire());

				inserEmprunt.setInt(4, emprunt.getIdEtudiant());
				inserEmprunt.setInt(5, emprunt.getEtat());

				inserEmprunt.executeUpdate();
				return true;
			}else {
				System.out.println(" il y a une erreur!!!");
				System.out.println(nbreExemplaireDispo);
			}
			}
			
			
			
		}

		catch (SQLException e) {

			System.out.println("add emprunt :" + e.getMessage());

		}

		return false;

	}

	private int calculerNbreExemplaire(int idExemplaire) {
		String requete = "SELECT ISBN FROM exemplaire  WHERE exemplaire.`idExemplaire` = " + idExemplaire;
	
 		int nbreExemplaire =0 ;
		
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

					nbreExemplaire++;
				}
				System.out.println(nbreExemplaire+ " " +  idExemplaire);
			} else {
				System.out.println("il n' y pas un livre avec cette ISBN ");
			}
				/*String requete1 = "SELECT idExemplaire FROM exemplaire  WHERE exemplaire.`ISBN` = " + isbn;
			 
				//ArrayList<Integer> listIDExemplaire = new ArrayList<Integer>();
				ps = conn.createStatement();
				rs = ps.executeQuery(requete1);
				while (rs.next()) {

				rs.getInt("idExemplaire");
				}
				*/
				 
			 		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String requete2 = "SELECT * FROM emprunt  WHERE emprunt.`idExemplaire` =  " + idExemplaire+ " and etat=0";
		int nbrEmprunt =0 ;
		try {
			ps = conn.createStatement();
			rs = ps.executeQuery(requete2);
			while (rs.next()) {
				nbrEmprunt++;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 		
		return  nbreExemplaire-nbrEmprunt;
		
	}
	
	
	@Override
	public boolean supprimer(int idEmprunt) {
		try {

			inserEmprunt = conn.prepareStatement("DELETE FROM `emprunt` WHERE `emprunt`.`idEmpt`  = ?");
			 
			inserEmprunt.setInt(1, idEmprunt);

			inserEmprunt.executeUpdate();
			return true;
		}

		catch (SQLException e) {

			System.out.println("Delete :"+ idEmprunt +" " + e.getMessage());

		}

		return false;

	}

	@Override
	public boolean modifierDateEmp(int idEmpt, Date nvDateEmp) {
		try {

			inserEmprunt = conn.prepareStatement(
					"UPDATE `emprunt` SET `DateEmprunt` = ? WHERE `emprunt`.`idEmpt` = ?;");

			inserEmprunt.setDate(1, nvDateEmp);
			inserEmprunt.setInt(2, idEmpt);

			inserEmprunt.executeUpdate();
			return true;
		}

		catch (SQLException e) {

			System.out.println("update :" + e.getMessage());

		}

		return false;
	}

	@Override
	public boolean modifierDateRet(int idEmpt,Date nvDateRet) {
		try {

			inserEmprunt = conn.prepareStatement(
					"UPDATE `emprunt` SET `DateRetour` = ?  WHERE `emprunt`.`idEmpt` = ?;");

			inserEmprunt.setDate(1, nvDateRet);
			inserEmprunt.setInt(2, idEmpt);

			inserEmprunt.executeUpdate();
			return true;
		}

		catch (SQLException e) {

			System.out.println("update DateRet :" + e.getMessage());

		}

		return false;
	}

	@Override
	public boolean modifieridExemplaire(int idEmpt, int nvIDExemplaire) {
		

		try {

			inserEmprunt = conn.prepareStatement(
					"UPDATE `emprunt` SET `idExemplaire` = ? WHERE `emprunt`.`idEmpt` = ?;");

			inserEmprunt.setInt(1, nvIDExemplaire);
			inserEmprunt.setInt(2, idEmpt);

			inserEmprunt.executeUpdate();
			return true;
		}

		catch (SQLException e) {

			System.out.println("update :" + e.getMessage());

		}

		return false;
	}

	@Override
	public boolean modifieridEtudiant(int idEmpt, int nbIDEtudiant) {
		try {

			inserEmprunt = conn.prepareStatement(
					"UPDATE `emprunt` SET `idEtudiant` = ? WHERE `emprunt`.`idEmpt` = ?;");

			inserEmprunt.setInt(1, nbIDEtudiant);
			inserEmprunt.setInt(2, idEmpt);

			inserEmprunt.executeUpdate();
			return true;
		}

		catch (SQLException e) {

			System.out.println("update :" + e.getMessage());

		}

		return false;
	}

	
	

}
