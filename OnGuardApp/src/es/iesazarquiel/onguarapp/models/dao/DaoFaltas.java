package es.iesazarquiel.onguarapp.models.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import es.iesazarquiel.onguarapp.models.conexiones.Conexion;
import es.iesazarquiel.onguarapp.models.entidades.Faltas;

public class DaoFaltas {
/************************METODO PARA INSERTAR FALTA DE UN PROFE [  CRIS  ]*******************************/
					//MEJORA: tener en cuenta si tiene clase esa hora
	
	public void insertarFalta(Faltas f) throws SQLException,Exception{
		Connection con = null;
		PreparedStatement st = null;
		String ordenSQL = "INSERT INTO FALTAS(COD_PROFE_FALTA,"
											+ "DIA_SEMANA_FALTA,"
											+ "HORA_FALTA,"
											+ "FECHA,"
											+ "COD_PROFE_CUBRE_GUARDIA,"
											+ "DIA_SEMANA_GUARDIA,"
											+ "HORA_GUARDIA) VALUES(?,?,?,?,?,?,?)";
		Conexion miconex = new Conexion();
		try{
			con=miconex.getConexion();
			con.setAutoCommit(false);		
			Date fecha=new Date(f.getFecha().getTime());
			st=con.prepareStatement(ordenSQL);
			st.setString(1,f.getCod_profe_falta());
			st.setString(2,f.getDia_semana_falta());
			st.setString(3,f.getHora_falta());
			st.setDate(4,fecha);
			st.setString(5, f.getCod_profe_guardia());
			st.setString(6, f.getDia_semana_guardia());
			st.setString(7, f.getHora_guardia());
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
	

/******************METODO PARA ASIGNAR FALTAS(QUIEN CUBRE LA GUARDIA) [  CRIS  ]***************************/		
					//MEJORA: tener en cuenta si tiene existe esa falta en Faltas
	
	public void asignarFaltaAProf(Faltas f) throws SQLException,Exception{
		Connection con = null;
		PreparedStatement st = null;
		String ordenSQL = "UPDATE FALTAS SET COD_PROFE_CUBRE_GUARDIA=?,"
											+ "DIA_SEMANA_GUARDIA=?,"
											+ "HORA_GUARDIA=?"
											+ "WHERE COD_PROFE_FALTA=? AND "
											+ "DIA_SEMANA_FALTA=? AND "
											+ "HORA_FALTA=? AND "
											+ "FECHA=?";
		Conexion miconex = new Conexion();
		try{
			con=miconex.getConexion();
			con.setAutoCommit(false);		
			st=con.prepareStatement(ordenSQL);
			Date fecha=new Date(f.getFecha().getTime());
			st.setString(1, f.getCod_profe_guardia());
			st.setString(2, f.getDia_semana_guardia());
			st.setString(3, f.getHora_guardia());
			st.setString(4,f.getCod_profe_falta());
			st.setString(5,f.getDia_semana_falta());
			st.setString(6,f.getHora_falta());
			st.setDate(7,fecha);
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
/*********************** METODO MOSTRAR FALTAS [ JOSE ]***********************************/
	
	public ArrayList<Faltas> mostrarFaltas() throws SQLException,Exception {
		ArrayList<Faltas> listaFaltas = new ArrayList<Faltas>();
		
		Connection con = null;
		ResultSet rs = null; 
		Statement st = null;
		Conexion conexion = new Conexion();
	    
		String ordenSQL;
		
		try {
		con=conexion.getConexion();	
		st = con.createStatement();
		ordenSQL ="SELECT * FROM FALTAS";
	    rs=st.executeQuery(ordenSQL);
	    while(rs.next()) {
	    	Faltas falta = new Faltas();
	    	falta.setCod_profe_falta(rs.getString("COD_PROFE_FALTA"));
	    	falta.setDia_semana_falta(rs.getString("DIA_SEMANA_FALTA"));
	    	falta.setHora_falta(rs.getString("HORA_FALTA"));
	    	falta.setFecha(rs.getDate("FECHA"));
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
	    
	    return listaFaltas;
	}
/*********************** METODO CONSULTAR FALTAS ENTRE 2FECHAS [ CARLOS ]***********************************/
	/*
	 *  Metodo al que se le pasa un codigo de profesor y dos fechas, y debe buscar
	 *  en la tabla de faltas mediante un select todas las faltas de ese codigo de profesor.
	 *  Devuelve un arraylist con varias l�neas, en cada l�nea va la fecha, 
	 *  la asignatura, el grupo y el profe que le cubri� (si lo hay). CARLOS.
	 * @throws SQLException 
	 * 
	 *   
	 */
	
	public ArrayList<String> verFaltasProf (String codProf, Date fechaIni, Date fechaFin) throws SQLException {
		
		String fechaIniNueva = transformarFecha(fechaIni);
		
		String fechaFinNueva = transformarFecha(fechaFin);
		
		ArrayList<String> faltasProf = new ArrayList<String>();
		
		/*Aqu� va el c�digo*/
		
		Connection con = null;
		ResultSet rs = null; 
		Statement st = null;
		Conexion conexion = new Conexion();
	    
		con=conexion.getConexion();	
		st = con.createStatement();
		String ordenSQL;
		
		ordenSQL = "SELECT DOCENTESF.NOMBRE PROFFALTA, DOCENTESG.NOMBRE PROFGUARDIA, "
				+ "FECHA, HORA_FALTA "
				+ "FROM FALTAS "
				+ "INNER JOIN DOCENTE DOCENTESF ON FALTAS.COD_PROFE_FALTA = DOCENTESF.COD_PROFE"
                + " INNER JOIN DOCENTE DOCENTESG ON FALTAS.COD_PROFE_CUBRE_GUARDIA = DOCENTESG.COD_PROFE " 
                + "WHERE FALTAS.FECHA BETWEEN '" + fechaIniNueva +
                "' AND '" + fechaFinNueva + "' AND DOCENTESF.COD_PROFE = '" + codProf + "'";
		rs=st.executeQuery(ordenSQL);
		
		while(rs.next()) {
	    	faltasProf.add(rs.getString("PROFFALTA"));
	    	faltasProf.add(rs.getDate("FECHA").toString());
	    	faltasProf.add(rs.getString("HORA_FALTA"));
	    	faltasProf.add(rs.getString("PROFGUARDIA"));
	    }
		
		
		return faltasProf;
		
	}
	
/*********************** METODO CONSULTAR GUARDIAS REALIZADAS ENTRE 2FECHAS [ CARLOS ]***********************************/
	/*
	 * Método al que se le pasa un código de profesor y dos fechas, y debe buscar
	 * en la tabla de faltas todas las filas que estén entre las dos fechas y tengan 
	 * rellena la columna COD_PROF_GUARDIA con ese código de profe. Devuelve un arraylist
	 * con varias líneas, en cada línea va la la fecha, el nombre del profe al que cubrió,
	 * y la asignatura y el grupo que cubrió. CARLOS.
	 */
	
public ArrayList<String> verGuardiasProf (String codProf, Date fechaIni, Date fechaFin) throws SQLException {
		
		String fechaIniNueva = transformarFecha(fechaIni);
		
		String fechaFinNueva = transformarFecha(fechaFin);
		
		ArrayList<String> guardiasProf = new ArrayList<String>();
		
		
		Connection con = null;
		ResultSet rs = null; 
		Statement st = null;
		Conexion conexion = new Conexion();
	    
		con=conexion.getConexion();	
		st = con.createStatement();
		String ordenSQL;
		
		ordenSQL = "select docentes_guardias.nombre profe_guardia, fecha, hora_falta, docentes_faltas.nombre profe_faltas " +
				"from faltas " 
				+"inner join docentes docentes_guardias on docentes_guardias.cod_profe=faltas.cod_profe_cubre_guardia "
				+"inner join docentes docentes_faltas on docentes_faltas.cod_profe=faltas.cod_profe_falta "
				+"where cod_profe_cubre_guardia ='" + codProf + "'"
				+ "and fecha between '"+ fechaIniNueva + "' and '"+ fechaFinNueva + "'";
		rs=st.executeQuery(ordenSQL);
		
		while(rs.next()) {
	    	guardiasProf.add(rs.getString("profe_guardia"));
	    	guardiasProf.add(rs.getDate("fecha").toString());
	    	guardiasProf.add(rs.getString("hora_falta"));
	    	guardiasProf.add(rs.getString("profe_faltas"));
	    }
		
		
		return guardiasProf;
		
	}
/*********************** METODO PARA EL INFORME DE FALTAS [ JOSE ]***********************************/
	/** 
	 * M�todo al que se le pasa una fecha y devuelve un arrayList con las 6 horas, y dentro de 
	 * cada hora, el profe que ha cubierto esa falta y el c�digo de aula. JOSE.
	 * @throws SQLException 
	 */
	
	public ArrayList<String> generarInformeFaltasCub (Date fechaInforme) throws SQLException {
		
		String fechaInformeNueva = transformarFecha(fechaInforme);
		
		Connection con = null;
		ResultSet rs = null; 
		Statement st = null;
		Conexion conexion = new Conexion();
	    
		con=conexion.getConexion();	
		st = con.createStatement();
		String ordenSQL;
		
		ArrayList<String> informeFaltasCub = new ArrayList<String>();
		
		ordenSQL = "SELECT HORA_FALTA, HORA_CLASE.COD_AULA, FALTAS.COD_PROFE_CUBRE_GUARDIA PROFG "
				+ "FROM FALTAS "
				+ "INNER JOIN DOCENTE ON FALTAS.COD_PROFE_FALTA = DOCENTE.COD_PROFE "
				+ "INNER JOIN HORA_CLASE ON FALTAS.COD_PROFE_FALTA = HORA_CLASE.COD_PROFE_CLASE AND "
				+ "FALTAS.DIA_SEMANA_FALTA = HORA_CLASE.DIA_SEMANA "
				+ "AND FALTAS.HORA_FALTA = HORA_CLASE.HORA "
				+ "WHERE FALTAS.FECHA = '" + fechaInformeNueva + "'";
		rs=st.executeQuery(ordenSQL);
		
		while(rs.next()) {
	    	informeFaltasCub.add(rs.getString("HORA_FALTA"));
	    	informeFaltasCub.add(rs.getString("COD_AULA"));
	    	informeFaltasCub.add(rs.getString("PROFG"));
	    }
		
		return informeFaltasCub;
		
	}
/*********************** METODO PARA VER EL HORARIO POR DIA Y POR PROFE [ JOSE ]***********************************/	
	/*
	 * Se le pasa un codigo de profe y un d�a de la semana, y devuelve las horas
	 * de clase o guardia que tiene ese profe ese dia.
	 * Se necesita para el m�todo Asignar Falta.
	 * @param codprof
	 * @param diaSem
	 */
	public ArrayList<String> verHorasDeUnDia(String codprof, String diaSem) {
		
		ArrayList<String> horasDia = new ArrayList<String>();
		
		return horasDia;
		
	}
/*********************** METODO PARA VER FALTAS DE UN DIA DE UN PROFE [ JOSE ]***********************************/
	/*
	 * Se le pasa un c�digo de profe y una fecha y devuelve las faltas de ese profe ese d�a.
	 * Este m�todo es necesario para hacer el m�todo Asignar Faltas.

	 */
	public ArrayList<String> verFaltasDeUnDia(String codProf, Date dia) throws SQLException {
		
        ArrayList<String> faltasDia = new ArrayList<String>();
		
		Connection con = null;
		ResultSet rs = null; 
		Statement st = null;
		Conexion conexion = new Conexion();
	    
		con=conexion.getConexion();	
		st = con.createStatement();
		String ordenSQL;
		
		ArrayList<String> informeFaltasCub = new ArrayList<String>();
		
		String diaFormateado = transformarFecha(dia);
		
		ordenSQL = "SELECT HORA_FALTA FROM FALTAS "
				+ "INNER JOIN DOCENTE ON FALTAS.COD_PROFE_FALTA = DOCENTE.COD_PROFE "
				+ "WHERE FALTAS.FECHA = '" + diaFormateado + "' "
				+ "AND FALTAS.COD_PROFE_FALTA = '" + codProf + "' ";
		
		rs=st.executeQuery(ordenSQL);
		
		while(rs.next()) {
	    	faltasDia.add(rs.getString("HORA_FALTA"));
	    }
		
		return faltasDia;
	}
	
/**************************** METODO PARA FORMATEAR LAS FECHAS [ JOSE ]***********************************/
	public String transformarFecha(Date fech) {
		
		String fech_ = fech.toString();
		String fechn = fech_.substring(8,10) + "-" + fech_.substring(5,7) + "-" + fech_.substring(0,4);
	    return fechn;
	}
	
	
}

