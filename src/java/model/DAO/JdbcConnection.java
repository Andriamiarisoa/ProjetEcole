package model.DAO;


import java.sql.*;
import java.lang.reflect.*;

public class JdbcConnection {
	
	//Simple function to connect to a database
	//ORACLE
	public static Connection getOracleConnection(String user,String pass){
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",user,pass);
 			System.out.println("successfully connected to Oracle as"+user);
		}
		catch(ClassNotFoundException | SQLException e){ 
			System.out.println(e.getMessage());
		}
		return con;
	}
	//POSTGRES
	public static Connection getPostgresConnection(String user,String password,String database){
		Connection con=null;
		try{
			Class.forName("org.postgresql.Driver");
			String url="jdbc:postgresql://localhost:5432/"+database;
			con = DriverManager.getConnection(url,user,password);
 			System.out.println("successfully connected to postgresql in the database:"+database);
		}
		catch(ClassNotFoundException | SQLException e){ 
			System.out.println(e.getMessage());
		}
		return con;
	}

}