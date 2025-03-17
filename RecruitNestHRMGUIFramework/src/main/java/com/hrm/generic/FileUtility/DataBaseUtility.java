package com.hrm.generic.FileUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	
Connection con;
	
	public void getDbconnection(String url,String username, String password ) throws SQLException {
		try {
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
	     con = DriverManager.getConnection(url, username, password);
		} catch(Exception e){
			
		}
	}
	public void getDbconnection() throws SQLException {    // hard code the url , username , password
		try {
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
	     con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:8091","root", "root");
		} catch(Exception e){
			
		}
	}
	public void closeDbconnection() throws SQLException {
		try {
		con.close();
	}catch (Exception e) {
		// TODO: handle exception
	}
	}
	public ResultSet executeSelectQuery(String query) throws Throwable {
		ResultSet result=null;
		try {
		Statement stat = con.createStatement();
		result = stat.executeQuery(query);
		
		}catch(Exception e) {
			
	}
		return result;

}
	public int executeNonSelectQuery(String query) throws Throwable {
		int result=0;
		try {
		Statement stat = con.createStatement();
		result=stat.executeUpdate(query);
	}catch (Exception e) {
		// TODO: handle exception
	}
		return result;
	
}
}


