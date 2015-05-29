package es.iesazarquiel.onguarapp.pruebas.controllers;

import java.sql.Connection;
import java.sql.SQLException;

import es.iesazarquiel.onguarapp.models.conexiones.Conexion;

public class Prueba {

	public static void main(String[] args) {
		/*************************PRUEBA DE CONEXION  [  CRIS  ]*************************/
		Conexion conexion = new Conexion();
				Connection con= null;
				try {
					con=conexion.getConexion();
					System.out.println("Todo ha ido bien...");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}

}
