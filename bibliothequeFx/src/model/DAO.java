package model;


	
	import java.sql.DriverManager;
	import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.ConfigurationException;

	import com.mysql.jdbc.Connection;

	public abstract class DAO<T> {
		static Connection conn=null;
		public static Connection myConn() {
			

			String serveurBD = "jdbc:mysql://127.0.0.1:3306/bibliotheque?autoReconnect=true&useSSL=false";
			String login = "root";
			String motPasse = "";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = (Connection) DriverManager.getConnection(serveurBD, login, motPasse);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Execption");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		public abstract void add(T t);
		public abstract ArrayList affichelist(T t);
	}


