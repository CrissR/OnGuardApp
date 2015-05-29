package es.iesazarquiel.onguarapp.pruebas.metodos;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iesazarquiel.onguarapp.models.dao.DaoFaltas;
import es.iesazarquiel.onguarapp.models.dao.DaoHoraGuardia;

public class PruebaVerFaltasProf {

    public static void main(String[] args) throws SQLException {
	
	DaoFaltas daofaltas = new DaoFaltas();
	
	ArrayList<String> lasFaltas = new ArrayList<String>();
	
	Date fechaprueba1 = Date.valueOf("2015-05-17");
	
	Date fechaprueba2 = Date.valueOf("2015-05-21");
	
	lasFaltas = daofaltas.verFaltasProf("profe002",fechaprueba1, fechaprueba2);
	
	for (String s : lasFaltas) {
		System.out.println(s);
	}
	
    }

	
}
