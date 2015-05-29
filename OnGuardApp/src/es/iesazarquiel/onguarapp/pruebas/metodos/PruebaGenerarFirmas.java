package es.iesazarquiel.onguarapp.pruebas.metodos;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iesazarquiel.onguarapp.models.dao.DaoFaltas;
import es.iesazarquiel.onguarapp.models.dao.DaoHoraGuardia;

public class PruebaGenerarFirmas {

public static void main(String[] args) throws SQLException {
		

		
		DaoHoraGuardia daohoraguardia = new DaoHoraGuardia();
		
		ArrayList<String> listaFirmas = new ArrayList<String>();
		
		listaFirmas = daohoraguardia.generarInformeGuardias("martes");
		
		for (String s : listaFirmas) {
			System.out.println(s);
		}

}
}