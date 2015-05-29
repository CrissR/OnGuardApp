package es.iesazarquiel.onguarapp.models.conexiones;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class Conexion {
	public Conexion() {
		// TODO Auto-generated constructor stub
	}
	/********************************CONEXION  [  CRIS  ]************************************************/
	public Connection getConexion() throws SQLException{
		//String url="jdbc:oracle:thin:SYSTEM/toledo@localhost:1521:xe";//CAMBIARLO POR LA IP DE LA MAQUINA PERSONAL
		String url="jdbc:oracle:thin:ONGUARD/ONGUARD@192.168.163.129:1521:orcl";  //CRIS
		OracleDataSource ods=new OracleDataSource();
		ods.setURL(url);
		Connection con;
		try{
			
			con=ods.getConnection();
			DatabaseMetaData meta = con.getMetaData();
			System.out.println("Data Source definido y conexion establecida");
			System.out.println("JDBC driver version is "+ meta.getDriverVersion());
		}
		catch(SQLException sqle){
			System.out.println(sqle.toString());
				throw sqle;
		}
		return con;
		
	}
}
