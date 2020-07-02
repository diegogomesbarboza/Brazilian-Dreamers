package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public Connection getConection() {
		
		String url = "jdbc:mysql://localhost:3306/brazilian_dreamers?user=diego";
		String user = "diego";
		String password =  "diego";
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
			
		}catch (Exception erro) {
			
			throw new RuntimeException ("Erro na conexão" + erro);
		}
	}
}
