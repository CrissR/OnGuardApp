package es.iesazarquiel.onguarapp.pruebas.metodos;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iesazarquiel.onguarapp.models.dao.DaoFaltas;

public class PruebaVerFaltasProfDia {

	public static void main(String[] args) throws SQLException {
		
		DaoFaltas daofaltas = new DaoFaltas();
		
		ArrayList<String> faltasDelDia = new ArrayList<String>();
		
		faltasDelDia = daofaltas.verFaltasDeUnDia("profe002", Date.valueOf("2015-05-19"));
		
		for (String s : faltasDelDia) {
			System.out.println(s);
		}

	}

}
