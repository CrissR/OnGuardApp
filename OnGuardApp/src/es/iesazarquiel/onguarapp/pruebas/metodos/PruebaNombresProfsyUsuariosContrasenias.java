package es.iesazarquiel.onguarapp.pruebas.metodos;

import java.sql.SQLException;
import java.util.ArrayList;

import es.iesazarquiel.onguarapp.models.dao.DaoDocente;

public class PruebaNombresProfsyUsuariosContrasenias {

	public static void main(String[] args) throws SQLException {
		
		
		DaoDocente daodocente = new DaoDocente();
		
		ArrayList<String> nombresProfs = new ArrayList<String>();
		
		nombresProfs = daodocente.getNombresProfesores();
		
		for (String s : nombresProfs) {
			System.out.println(s);
		}
		
		ArrayList<String> ususyContrs = new ArrayList<String>();
		
		ususyContrs = daodocente.getUsuariosyContrasenias();
		
		for (String s: ususyContrs)
		System.out.println(s);

	}

}
