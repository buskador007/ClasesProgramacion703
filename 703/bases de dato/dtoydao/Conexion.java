package dtoydao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Conexion {
	
	Connection conn = null;
	ResultSet rset = null;
	Statement stmt = null;
	
	public Connection establecerconn() {
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			conn = DriverManager.getConnection ("jdbc:oracle:thin:@localhost:1521:xe", "HR", "medaigual");
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery("select * from employees where  salary > 3000");
			
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void cerraconn(){
		
		if (rset != null) 	{ try { rset.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
				
	}	
	
	
}
