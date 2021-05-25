package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDatabase {
	
	public static Connection makeConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/BobaCooldatabase?useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(connection== null) {
			System.out.println("Error occured when making connection");
		}else {
			System.out.println("Success");
		}
		
		return connection; 
	}
} 

