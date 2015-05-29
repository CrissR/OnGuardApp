package es.iesazarquiel.onguarapp.pruebas.controllers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iesazarquiel.onguarapp.models.conexiones.Conexion;
import es.iesazarquiel.onguarapp.models.dao.DaoFaltas;
import es.iesazarquiel.onguarapp.models.entidades.Faltas;

public class PruebaDaoFaltas {

	public static void main(String[] args) {
/*************************PRUEBA DE CONEXION*************************/
		Conexion conexion = new Conexion();
		Connection con= null;
		try {
			con=conexion.getConexion();
			System.out.println("-> La conexion va bien... <-");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

/********************PRUEBA AL METODO DE INSERTAR FALTA  [  CRIS  ]**************************************/		
	/*	Faltas falta1=new Faltas();
		DaoFaltas daofalta=new DaoFaltas();
		falta1.setCod_profe_falta("profe001");
		falta1.setDia_semana_falta("lunes");
		falta1.setHora_falta("hora2");
		falta1.setFecha(Date.valueOf("2015-05-26"));
		falta1.setCod_profe_guardia(null);
		falta1.setDia_semana_guardia(null);
		falta1.setHora_guardia(null);
		//System.out.println("-> Se ha insertado la falta <-.");
			try {
				daofalta.insertarFalta(falta1);
				} catch (SQLException e) {
				e.printStackTrace();
				} catch (Exception e) {
				e.printStackTrace();
			}*/
/********************PRUEBA AL METODO DE ASIGNAR FALTA (CUBIR FALTA) [  CRIS  ]**************************************/			
/*		Faltas guardia=new Faltas();	
		DaoFaltas  daofalta=new DaoFaltas();
		guardia.setCod_profe_falta("profe001");
		guardia.setDia_semana_falta("lunes");
		guardia.setHora_falta("hora2");
		guardia.setFecha(Date.valueOf("2015-05-23"));
		guardia.setCod_profe_guardia("profe002");
		guardia.setDia_semana_guardia("lunes");
		guardia.setHora_guardia("hora2");
		//System.out.println("-> Se ha asignado profe para cubrir falta <-.");
		try {
			daofalta.asignarFaltaAProf(guardia);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
/*************************PRUEBA LISTAR FALTAS  [ JOSE ]*************************/
		Conexion conexion1 = new Conexion();
				Connection con1= null;
								
				try {
					DaoFaltas daoFaltas = new DaoFaltas();
					ArrayList<Faltas> lasFaltas = daoFaltas.mostrarFaltas();
					
					for (int i=0; i<lasFaltas.size(); i++) {
					System.out.print(lasFaltas.get(i).getCod_profe_falta() + " - ");
					System.out.print(lasFaltas.get(i).getDia_semana_falta() + " - ");
					System.out.print(lasFaltas.get(i).getHora_falta() + " - ");
					System.out.print(lasFaltas.get(i).getFecha());
					System.out.println();
					}
					
										
				} catch (SQLException se) {
					System.out.println(se.getMessage());
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				
	}

}
