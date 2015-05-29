package es.iesazarquiel.onguarapp.pruebas.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iesazarquiel.onguarapp.models.conexiones.Conexion;
import es.iesazarquiel.onguarapp.models.dao.DaoHoraClase;
import es.iesazarquiel.onguarapp.models.entidades.HoraClase;

public class PruebaDaoHoraClase {

	public static void main(String[] args) {

/****************************PRUEBA LISTAR HORARIO [ JOSE ]*****************************/
		Conexion conexion = new Conexion();
				Connection con= null;
								
				try {
					DaoHoraClase daohorasclase = new DaoHoraClase();
					ArrayList<HoraClase> lasHoras = daohorasclase.mostrarHorasClase();
					
					for (int i=0; i<lasHoras.size(); i++) {
					System.out.print(lasHoras.get(i).getCod_profe_clase() + " - ");
					System.out.print(lasHoras.get(i).getDia_semana() + " - ");
					System.out.print(lasHoras.get(i).getHora() + " - ");
					System.out.print(lasHoras.get(i).getCod_asignatura());
					System.out.println();
					}
					
					/*
					 * for (Socio s: listadoSocios) {
					 * System.out.println("IDSOCIO: " + s.getIdsocio());
					 */
					
				} catch (SQLException se) {
					System.out.println(se.getMessage());
					
				}catch (Exception e) {
					e.printStackTrace();
				}

	}

}
