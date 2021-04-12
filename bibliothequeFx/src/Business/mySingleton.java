package Business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 
public class mySingleton {
	private static mySingleton instance=null;


 	private static String serveurBD = "jdbc:mysql://127.0.0.1:3306/bibliotheque?autoReconnect=true&useSSL=false";
	private static String login = "root";
	private static String motPasse = "";
	
  	private static Connection conn=null;
	private mySingleton() {
		 
		
	}
	
	public static mySingleton getInstance(){
		
	  if(instance == null) {
	    instance = new mySingleton();
	  }
	  return instance;
	  
	}
	
	
	public Connection getConnection() {
	 
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		 
		try {
			conn = DriverManager.getConnection(serveurBD, login, motPasse);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	

}






















