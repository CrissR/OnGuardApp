package es.iesazarquiel.onguarapp.pruebas.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iesazarquiel.onguarapp.models.conexiones.Conexion;
import es.iesazarquiel.onguarapp.models.dao.DaoAsignatura;
import es.iesazarquiel.onguarapp.models.entidades.Asignatura;
import es.iesazarquiel.onguarapp.pruebas.metodos.DaoAsignaturaP;

public class PruebaDaoAsignaturaP {

	public static void main(String[] args) {
		
/*************************PRUEBA MOSTRARASIGNATURA  [  JOSE  ]*************************/
		Conexion conexion = new Conexion();
				Connection con= null;
								
				try {
					DaoAsignaturaP daoAsignatura = new DaoAsignaturaP();
					ArrayList<Asignatura> lasAsignaturas = daoAsignatura.mostrarAsignaturas();
					
					for (int i=0; i<lasAsignaturas.size(); i++) {
					System.out.print(lasAsignaturas.get(i).getCod_asignatura() + " - ");
					System.out.print(lasAsignaturas.get(i).getNombre());
					System.out.println();
					}
					
										
				} catch (SQLException se) {
					System.out.println(se.getMessage());
					
				}catch (Exception e) {
					e.printStackTrace();
				}

	}

}
