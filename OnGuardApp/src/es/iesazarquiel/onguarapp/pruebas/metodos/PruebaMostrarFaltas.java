package es.iesazarquiel.onguarapp.pruebas.metodos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iesazarquiel.onguarapp.models.conexiones.Conexion;
import es.iesazarquiel.onguarapp.models.dao.DaoAsignatura;
import es.iesazarquiel.onguarapp.models.dao.DaoFaltas;
import es.iesazarquiel.onguarapp.models.dao.DaoDocente;
import es.iesazarquiel.onguarapp.models.dao.DaoHoraClase;
import es.iesazarquiel.onguarapp.models.entidades.Asignatura;
import es.iesazarquiel.onguarapp.models.entidades.Faltas;
import es.iesazarquiel.onguarapp.models.entidades.HoraClase;
import es.iesazarquiel.onguarapp.models.entidades.Docente;

public class PruebaMostrarFaltas {


	public static void main(String[] args) {
/*************************PRUEBA DE CONEXION*************************/
		Conexion conexion = new Conexion();
				Connection con= null;
								
				try {
					DaoFaltas daoFaltas = new DaoFaltas();
					ArrayList<Faltas> lasFaltas = daoFaltas.mostrarFaltas();
					
					for (int i=0; i<lasFaltas.size(); i++) {
					System.out.print(lasFaltas.get(i).getCod_profe_falta() + " - ");
					System.out.print(lasFaltas.get(i).getDia_semana_falta() + " - ");
					System.out.print(lasFaltas.get(i).getHora_falta() + " - ");
					System.out.print(lasFaltas.get(i).getFecha());
					System.out.println();
					}
					
										
				} catch (SQLException se) {
					System.out.println(se.getMessage());
					
				}catch (Exception e) {
					e.printStackTrace();
				}

			}
	
}
