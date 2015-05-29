package es.iesazarquiel.onguarapp.models.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.iesazarquiel.onguarapp.models.conexiones.Conexion;
import es.iesazarquiel.onguarapp.models.entidades.Docente;

public class DaoDocente {

/** ********************METODO PARA MOSTRAR TODOS LOS DOCENTES [  JOSE  ]*********************/
	public ArrayList<Docente> mostrarDocentes() throws SQLException,Exception {
		    ArrayList<Docente> listaDocentes = new ArrayList<Docente>();
			
			Connection con = null;
			ResultSet rs = null; 
			Statement st = null;
			Conexion conexion = new Conexion();
		    
			String ordenSQL;
			
			try {
			con=conexion.getConexion();	
			st = con.createStatement();
			ordenSQL ="SELECT * FROM DOCENTE";
		    rs=st.executeQuery(ordenSQL);
		    while(rs.next()) {
		    	Docente docente = new Docente();
		    	docente.setCod_profe(rs.getString("COD_PROFE"));
		    	docente.setNombre(rs.getString("NOMBRE"));
		    	listaDocentes.add(docente);
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
		    
		    return listaDocentes;
		    
	}
	

/******************METODO PARA MOSTRAR CODIGO DE PROFE A PARTIR DEL NOMBRE [  JOSE  ]******************/

	public String encontrarCodigo(String nombreProf) throws SQLException {
		String codProf = "";
		
		Connection con = null;
		ResultSet rs = null; 
		Statement st = null;
		Conexion conexion = new Conexion();
	    
		con=conexion.getConexion();	
		st = con.createStatement();
		String ordenSQL;
		
		ordenSQL = "SELECT COD_PROFE FROM DOCENTE WHERE LOWER(NOMBRE) = LOWER('" + nombreProf +"')";
		rs=st.executeQuery(ordenSQL);
		
		while(rs.next())
	    codProf = (rs.getString("COD_PROFE"));
	
		
		return codProf;
		
	}
	
/******************METODO PARA MOSTRAR EL NOMBRE DEL PROFE A PARTIR DEL CODIGO [  JOSE  ]*********************/

	public String encontrarNombre(String codProf) throws SQLException {
		String nombreProf = "";
		
		Connection con = null;
		ResultSet rs = null; 
		Statement st = null;
		Conexion conexion = new Conexion();
	    
		con=conexion.getConexion();	
		st = con.createStatement();
		String ordenSQL;
		
		ordenSQL = "SELECT NOMBRE FROM DOCENTE WHERE LOWER(COD_PROFE) = LOWER('" + codProf +"')";
		rs=st.executeQuery(ordenSQL);
		
		while(rs.next())
	    nombreProf = (rs.getString("NOMBRE"));
	
		
		return nombreProf;
	}

/**********************METODO PARA MOSTRAR EL NOMBRE DE TODOS LOS DOCENTES [  JOSE  ]*********************/

	public ArrayList<String> getNombresProfesores() throws SQLException {
		
		ArrayList<String> nombresProfesores = new ArrayList<String>();
		
		Connection con = null;
		ResultSet rs = null; 
		Statement st = null;
		Conexion conexion = new Conexion();
	    
		con=conexion.getConexion();	
		st = con.createStatement();
		String ordenSQL;
		
		ordenSQL = "SELECT NOMBRE FROM DOCENTE";
		rs=st.executeQuery(ordenSQL);
		
		while(rs.next())
	    nombresProfesores.add(rs.getString("NOMBRE"));
	
		
		return nombresProfesores;
		
	}
	
/**********************METODO MOSTRAR USUARIO Y NOMBRE DE PROFE [  JOSE  ]*********************/
	
public ArrayList<String> getUsuariosyContrasenias() throws SQLException {
		
		ArrayList<String> UsuariosContrasenias = new ArrayList<String>();
		
		Connection con = null;
		ResultSet rs = null; 
		Statement st = null;
		Conexion conexion = new Conexion();
	    
		con=conexion.getConexion();	
		st = con.createStatement();
		String ordenSQL;
		
		ordenSQL = "SELECT USUARIO, PASSWORD FROM DOCENTE";
		rs=st.executeQuery(ordenSQL);
		
		while(rs.next()) {
		
		UsuariosContrasenias.add(rs.getString("USUARIO"));
		UsuariosContrasenias.add(rs.getString("PASSWORD"));
		}
		return UsuariosContrasenias;
		
	}
/**********************METODO MOSTRAR EL TIPO PROFE [  JOSE  ]********************************/

	public String getTipoDocente(String usuario) throws SQLException {
		
		String tipo = "";
		Connection con = null;
		ResultSet rs = null; 
		Statement st = null;
		Conexion conexion = new Conexion();
	    
		con=conexion.getConexion();	
		st = con.createStatement();
		String ordenSQL;
		
		ordenSQL = "SELECT TIPO FROM DOCENTE WHERE USUARIO = '" + usuario + "'";
		rs=st.executeQuery(ordenSQL);
		
		while(rs.next()) {
		
		tipo = rs.getString("TIPO");
		
		}
		return tipo;
		
	}
		
		
}
