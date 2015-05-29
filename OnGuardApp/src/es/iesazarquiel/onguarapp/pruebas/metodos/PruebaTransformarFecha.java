package es.iesazarquiel.onguarapp.pruebas.metodos;

import java.sql.Date;

import es.iesazarquiel.onguarapp.models.dao.DaoFaltas;

public class PruebaTransformarFecha {

   public static void main(String[] args) {
	   
	   Date fecha1 = Date.valueOf("2015-05-18");
	   
	   //System.out.println(fecha1.toString());
	   
	   DaoFaltas daofaltas = new DaoFaltas();
	   
	   String fecha2 = daofaltas.transformarFecha(fecha1);
	   
	   System.out.println(fecha2);
	   
   }

}
