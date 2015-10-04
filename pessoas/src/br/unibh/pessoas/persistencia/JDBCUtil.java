package br.unibh.pessoas.persistencia;

import java.sql.DriverManager;
import java.sql.Connection;

public class JDBCUtil {

	private static Connection con;
	
	// Fazer conexão
	public static Connection getConnection() throws Exception {
		if (con == null || con.isClosed()){
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/unibh",
					"unibh",
					"1234");
		}
		return con;
	}
	
	// Fecha a conexão	
	public static void closeConnection() {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (Exception e){
			e.printStackTrace();
		}	
	}
	
}
