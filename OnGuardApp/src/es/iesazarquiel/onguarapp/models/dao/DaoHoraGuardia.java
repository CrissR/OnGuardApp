package es.iesazarquiel.onguarapp.models.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.iesazarquiel.onguarapp.models.conexiones.Conexion;
import es.iesazarquiel.onguarapp.models.entidades.HoraGuardia;

public class DaoHoraGuardia {
/************************METODO PARA LISTAR HORAS_GUARDIA [  ALEJANDRO  ]**********************************/
	public ArrayList<HoraGuardia> mostrarHorasGuardia() throws SQLException,Exception {
		ArrayList<HoraGuardia> listaHorasGuardia = new ArrayList<HoraGuardia>();
		
		Connection con = null;
		ResultSet rs = null; 
		Statement st = null;
		Conexion conexion = new Conexion();
	    
		String ordenSQL;
		
		try {
		con=conexion.getConexion();	
		st = con.createStatement();
		ordenSQL ="SELECT * FROM HORA_GUARDIA";
	    rs=st.executeQuery(ordenSQL);
	    while(rs.next()) {
	    	HoraGuardia horaGuardia = new HoraGuardia();
	    	horaGuardia.setCod_profe_guardia(rs.getString("COD_PROFE_GUARDIA"));
	    	horaGuardia.setDia_semana(rs.getString("DIA_SEMANA"));
	    	horaGuardia.setHora(rs.getString("HORA"));
	    	horaGuardia.setFirmado(rs.getString("FIRMADO"));
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
	    
	    return listaHorasGuardia;
	    }
/************************METODO PARA FIRMAR GUARDIA [  ANA  ]**********************************/	
			//MEJORA: comprobar si tiene guardia
	
	public void firmarGuardia(HoraGuardia g) throws SQLException,Exception{
		Connection con =null;
		PreparedStatement st = null;
		String ordenSQL = "UPDATE HORA_GUARDIA SET FIRMADO =?"
													+ "WHERE COD_PROFE_GUARDIA =? AND "
													+ "DIA_SEMANA =? AND "
													+ "HORA =?";
		Conexion miconex = new Conexion();
		try{
			con=miconex.getConexion();
			con.setAutoCommit(false);		
			st=con.prepareStatement(ordenSQL);
			st.setString(1, g.getFirmado());
			st.setString(2, g.getCod_profe_guardia());
			st.setString(3, g.getDia_semana());
			st.setString(4, g.getHora());
			st.executeUpdate();
			con.commit();
		}catch (SQLException sqle){
			throw sqle;
		}catch (Exception e){
			throw e;
		}finally{				
			if(st !=null)
			st.close();
		if (con !=null)
			con.close();
		
		}
	}
/************************METODO PARA LISTAR HORAS_GUARDIA/DIA [  JOSE  ]**********************************/	
	/*
	 * M�todo al que se le pasa un d�a de la semana y devuelve una arraylist 
	 * con las 6 horas y los 
	 * profes que, dentro de cada hora, han firmado la guardia. JOSE.
	 * @throws SQLException 
	 */
	
	public ArrayList<String> generarInformeGuardias (String diaSem) throws SQLException {
		
		ArrayList<String> firmas = new ArrayList<String>();
		
		Connection con = null;
		ResultSet rs = null; 
		Statement st = null;
		Conexion conexion = new Conexion();
	    
		con=conexion.getConexion();	
		st = con.createStatement();
		String ordenSQL;
		
		ordenSQL = "SELECT HORA_GUARDIA.HORA, DOCENTE.NOMBRE "
				+ "FROM HORA_GUARDIA "
				+ "INNER JOIN DOCENTE ON HORA_GUARDIA.COD_PROFE_GUARDIA = DOCENTE.COD_PROFE "
		        + "WHERE DIA_SEMANA = '" + diaSem + "'"
				+ "AND FIRMADO='SI'";
		
		rs=st.executeQuery(ordenSQL);
		
		while(rs.next()) {
	    	firmas.add(rs.getString("NOMBRE"));
	    	firmas.add(rs.getString("HORA"));
	    }
		
		return firmas;
	
		
		
	}
/*****************METODO FORMATEAR COLUMNA FIRMADO SEMANALMENTE [  CRIS  ]*****************/	
	/**
	 * Se ha ralizado con un procedimiento y un trabajo dentro de la base de datos
	 */

}
