package es.iesazarquiel.onguarapp.models.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.iesazarquiel.onguarapp.models.conexiones.Conexion;
import es.iesazarquiel.onguarapp.models.entidades.HoraClase;

public class DaoHoraClase {

/*******************METODO PARA LISTAR EL HORARIO [ JOSE ]**********************************/
public ArrayList<HoraClase> mostrarHorasClase() throws SQLException,Exception {
		
		ArrayList<HoraClase> listaHoras = new ArrayList<HoraClase>();
		
		Connection con = null;
		ResultSet rs = null;  //esto dice que seria un cursor (conjunto de resultados)
		Statement st = null;
		Conexion conexion = new Conexion();
	    
		String ordenSQL;
		
		try {
		con=conexion.getConexion();	
		st = con.createStatement();
		ordenSQL ="SELECT * FROM HORA_CLASE";
	    rs=st.executeQuery(ordenSQL);
	    while(rs.next()) {
	    	HoraClase horaclase = new HoraClase();
	    	horaclase.setCod_profe_clase(rs.getString("COD_PROFE_CLASE"));
	    	horaclase.setDia_semana(rs.getString("DIA_SEMANA"));
	    	horaclase.setHora(rs.getString("HORA"));
	    	horaclase.setCod_asignatura(rs.getString("COD_ASIGNATURA"));
	    	
	    	listaHoras.add(horaclase);
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
	    
	    return listaHoras;
	  	}
/*******************METODO PARA LISTAR EL HORARIO SEGUN PROFE [ ALEJANDDRO ]******************/
	/*
	 * M�todo al que se le pasa como argumento un c�digo de profesor y tiene que 
	 * devolver las horas que tiene en la semana, para ello tendr� que consultar
	 * dos tablas: HORAS_CLASE Y HORA_GUARDIA. Alejandro.
	 */
	
	public ArrayList<String> mostrarHorasProf(String codProf) throws SQLException {
		
		ArrayList<String> horasProf = new ArrayList<String>();
		
		Connection con = null;
		ResultSet rs = null;  //esto dice que ser�a un cursor (conjunto de resultados)
		Statement st = null;
		Conexion conexion = new Conexion();
	    
		String ordenSQL;
		
	
		con=conexion.getConexion();	
		st = con.createStatement();
		ordenSQL ="SELECT dia_semana dia,hora, cod_asignatura asignatura "
					+ "FROM hora_clase "
					+ "where cod_profe_clase ='" + codProf +  "'";
	    rs=st.executeQuery(ordenSQL);
	    while(rs.next()) {
	    	horasProf.add(rs.getString("dia"));
	    	horasProf.add(rs.getString("hora"));
	    	horasProf.add(rs.getString("asignatura"));  		
	}
		return horasProf;
	}
}
