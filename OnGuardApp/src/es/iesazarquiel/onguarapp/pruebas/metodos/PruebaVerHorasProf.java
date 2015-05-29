package es.iesazarquiel.onguarapp.pruebas.metodos;

	import java.sql.SQLException;
	import java.util.ArrayList;



	import es.iesazarquiel.onguarapp.models.dao.DaoHoraClase;

	public class PruebaVerHorasProf {

		public static void main(String[] args) throws SQLException {
			
			DaoHoraClase daohoraclase = new DaoHoraClase();
			ArrayList<String> horario = new ArrayList<String>();
			
			horario = daohoraclase.mostrarHorasProf("profe004");
			
			for (int i = 0; i < horario.size(); i++) {
				System.out.println(horario.get(i));
			}

		}

	}


