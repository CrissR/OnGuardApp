package es.iesazarquiel.onguarapp.pruebas.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iesazarquiel.onguarapp.models.conexiones.Conexion;
import es.iesazarquiel.onguarapp.models.dao.DaoHoraGuardia;
import es.iesazarquiel.onguarapp.models.entidades.HoraGuardia;

public class PruebaDaoHoraGuardia {

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
		
/********************PRUEBA AL METODO DE FIRMAR GUARDIA[ ANA  ]**************************************/			
/*	HoraGuardia firma1= new HoraGuardia();
	DaoHoraGuardia daoguardia= new DaoHoraGuardia();
	firma1.setCod_profe_guardia("profe004");
	firma1.setDia_semana("lunes");
	firma1.setHora("hora6");
	firma1.setFirmado("NO");
	//System.out.println("-> Se ha firmado la guardia <-.");
	try {
		daoguardia.firmarGuardia(firma1);
	} catch (SQLException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}*/
	
/*************************PRUEBA LISTAR GUARDIAS  [ JOSE ]*************************/
	Conexion conexion1 = new Conexion();
	Connection con1= null;
							
			try {
				DaoHoraGuardia daoHoraGuardia = new DaoHoraGuardia();
				ArrayList<HoraGuardia> lasHorasGuardia = daoHoraGuardia.mostrarHorasGuardia();
				
				for (int i=0; i<lasHorasGuardia.size(); i++) {
				System.out.print(lasHorasGuardia.get(i).getCod_profe_guardia() + " - ");
				System.out.print(lasHorasGuardia.get(i).getDia_semana() + " - ");
				System.out.print(lasHorasGuardia.get(i).getHora() + " - ");
				System.out.print(lasHorasGuardia.get(i).getFirmado());
				System.out.println();
				}
								
			} catch (SQLException se) {
				System.out.println(se.getMessage());
				
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

}
