package es.iesazarquiel.onguarapp.pruebas.metodos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.iesazarquiel.onguarapp.models.conexiones.Conexion;
import es.iesazarquiel.onguarapp.models.entidades.Asignatura;


public class DaoAsignaturaP {
	
/************************** METODO PARA MOSTRAR LAS ASIGNATURAS [  JOSE  ]************************/
	public ArrayList<Asignatura> mostrarAsignaturas() throws SQLException,Exception {
		ArrayList<Asignatura> listaAsignaturas = new ArrayList<Asignatura>();
		
		Connection con = null;
		ResultSet rs = null; 
		Statement st = null;
		Conexion conexion = new Conexion();
	    
		String ordenSQL;
		
		try {
		con=conexion.getConexion();	
		st = con.createStatement();
		ordenSQL ="SELECT * FROM ASIGNATURA";
	    rs=st.executeQuery(ordenSQL);
	    while(rs.next()) {
	    	Asignatura asignatura = new Asignatura();
	    	asignatura.setCod_asignatura(rs.getString("COD_ASIGNATURA"));
	    	asignatura.setNombre(rs.getString("NOMBRE"));
	    	listaAsignaturas.add(asignatura);
	    }
		} catch (SQLException se) {
			throw se;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con!=null)
				con.close();
		}
	    
	    return listaAsignaturas;
	    
	    
	}
}
