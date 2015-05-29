package es.iesazarquiel.onguarapp.pruebas.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iesazarquiel.onguarapp.models.conexiones.Conexion;
import es.iesazarquiel.onguarapp.models.dao.DaoDocente;
import es.iesazarquiel.onguarapp.models.entidades.Docente;

public class PruebaDaoDocente {

	public static void main(String[] args) {
		
/*************************PRUEBA METODO MOSTRAR DOCENTES  [ JOSE ]*************************/
		Conexion conexion = new Conexion();
		Connection con= null;
								
		try {
			DaoDocente daodocente = new DaoDocente();
			ArrayList<Docente> losDocentes = daodocente.mostrarDocentes();
			
			for (int i=0; i<losDocentes.size(); i++) {
			System.out.print(losDocentes.get(i).getCod_profe() + " - ");
			System.out.print(losDocentes.get(i).getNombre());
			System.out.println();
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
					
				}catch (Exception e) {
					e.printStackTrace();
				}
	}

}
