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
import IserviceDAO.IDAOGererNouveauEmp;

public class ImpDAOGererNouveauEmp implements IDAOGererNouveauEmp {

	private PreparedStatement inserEmprunt = null;
	private static Statement ps = null;
	private int nbreExemplaireDispo=0;

	private static ResultSet rs = null;
	private mySingleton mySing = mySingleton.getInstance();

	private Connection conn = mySing.getConnection();
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
			isbn++;

			}
			
				String requete1 = "SELECT idExemplaire FROM exemplaire  WHERE exemplaire.`ISBN` = " + isbn;
			 
				ArrayList<Integer> listIDExemplaire = new ArrayList<Integer>();
				ps = conn.createStatement();
				rs = ps.executeQuery(requete1);
				while (rs.next()) {

					listIDExemplaire.add(rs.getInt("idExemplaire"));
				}
				
				 
			 		
			
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

			inserEmprunt = conn.prepareStatement("DDELETE FROM `emprunt` WHERE `emprunt`.`idEmpt`  = ?");
			 
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
