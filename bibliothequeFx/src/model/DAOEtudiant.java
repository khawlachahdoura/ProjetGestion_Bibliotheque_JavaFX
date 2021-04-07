package model;


	

	import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
	import java.util.ArrayList;

	import com.mysql.jdbc.Connection;
	import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Entities.Emprunt;
import Entities.Etudiant;
import Entities.Livre;



	public class DAOEtudiant extends DAO<Etudiant> {
		//static Connection conn=myConn();
		
		
		


		public static ArrayList affichelist1() {
			ArrayList<Etudiant> etudiant =new ArrayList();
			Connection conn= myConn();
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
					int codeEtudiant= (int) rs.getLong("codeEtudiant");
					 String nom = rs.getString("nom");
					 String prenom = rs.getString("prenom");
					 String groupe=rs.getString("groupe");
					
					Etudiant E1 = new Etudiant(codeEtudiant,nom,prenom,groupe);
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
			Connection conn= myConn();
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
					
					Emprunt E1 = new Emprunt(idExemplaire,idEtudiant,DateEmprunt,DateRetour,etat);
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
			Connection conn= myConn();
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


		@Override
		public void add(Etudiant t) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public ArrayList affichelist(Etudiant t) {
			// TODO Auto-generated method stub
			return null;
		}

}
