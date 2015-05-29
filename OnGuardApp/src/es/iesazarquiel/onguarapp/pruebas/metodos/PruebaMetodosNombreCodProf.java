package es.iesazarquiel.onguarapp.pruebas.metodos;

import java.sql.SQLException;

import es.iesazarquiel.onguarapp.models.dao.DaoDocente;

public class PruebaMetodosNombreCodProf {
	
	
	public static void main (String[] args) throws SQLException {
		
		DaoDocente daodocente = new DaoDocente();
		
		String codBuscado = daodocente.encontrarCodigo("Raquel");
		
		System.out.println(codBuscado);
		
		String nombreBuscado = daodocente.encontrarNombre("profe002");
		
		System.out.println(nombreBuscado);
		
	}

}
