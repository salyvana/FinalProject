package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import db.connectDatabase;
import model.model; 
import db.connectDatabase;

public class dao {
	
	Connection connection; 
	
	
	public dao() {
		try {
			initConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}	
	
	private void initConnection() throws SQLException {
		connection = connectDatabase.makeConnection();
		if (connection == null) {
			throw new SQLException("Connection");
		}
	}
	
	public Vector<Vector<String>> getData() {
		Vector<Vector<String>> data = new Vector<>();
		try {
			Statement stmt = connection.createStatement();
			String query = "select * from data";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Vector<String> subdata = new Vector<>();
				subdata.add(rs.getString(1));
				subdata.add(rs.getString(2));
				subdata.add(rs.getString(3));
				subdata.add(rs.getString(4));
				data.add(subdata);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} 
			return data; 
		
	}																						

	public void insert(model data) {
		try {
			Statement stmt = connection.createStatement();
			String query = String.format ("insert data values :('%s', '%s', '%s', '%s' ) " , data.getCode(), data.getNama(), data.getHarga(), data.getStock()); 
			stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	

	public void delete(String code) {
		try {
			Statement stmt =  connection.createStatement();
			String query = "delete from data where id =" + code + ""; 
			stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void update(model data) {				
		try {
			Statement stmt = connection.createStatement();
			String query = String.format ("update data values id = '%s', nama= '%s',harga= '%s', stock= '%s' ) " , data.getCode(), data.getNama(), data.getHarga(), data.getStock());
			stmt.execute(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}