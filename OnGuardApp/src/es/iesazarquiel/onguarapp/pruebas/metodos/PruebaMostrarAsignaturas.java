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
import es.iesazarquiel.onguarapp.models.entidades.HoraClase;
import es.iesazarquiel.onguarapp.models.entidades.Docente;

public class PruebaMostrarAsignaturas {


	public static void main(String[] args) {
/*************************PRUEBA DE CONEXION*************************/
		Conexion conexion = new Conexion();
				Connection con= null;
								
				try {
					DaoAsignatura daoAsignatura = new DaoAsignatura();
					ArrayList<Asignatura> lasAsignaturas = daoAsignatura.mostrarAsignaturas();
					
					for (int i=0; i<lasAsignaturas.size(); i++) {
					System.out.print(lasAsignaturas.get(i).getCod_asignatura() + " - ");
					System.out.print(lasAsignaturas.get(i).getNombre());
					System.out.println();
					}
					
										
				} catch (SQLException se) {
					System.out.println(se.getMessage());
					
				}catch (Exception e) {
					e.printStackTrace();
				}

			}
	
}
