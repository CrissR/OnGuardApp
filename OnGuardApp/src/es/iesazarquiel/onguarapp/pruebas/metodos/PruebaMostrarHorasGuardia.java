package es.iesazarquiel.onguarapp.pruebas.metodos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import es.iesazarquiel.onguarapp.models.conexiones.Conexion;
import es.iesazarquiel.onguarapp.models.dao.DaoAsignatura;
import es.iesazarquiel.onguarapp.models.dao.DaoFaltas;
import es.iesazarquiel.onguarapp.models.dao.DaoDocente;
import es.iesazarquiel.onguarapp.models.dao.DaoHoraGuardia;
import es.iesazarquiel.onguarapp.models.dao.DaoHoraClase;
import es.iesazarquiel.onguarapp.models.entidades.Asignatura;
import es.iesazarquiel.onguarapp.models.entidades.Faltas;
import es.iesazarquiel.onguarapp.models.entidades.HoraClase;
import es.iesazarquiel.onguarapp.models.entidades.Docente;
import es.iesazarquiel.onguarapp.models.entidades.HoraGuardia;

public class PruebaMostrarHorasGuardia {


	public static void main(String[] args) {
/*************************PRUEBA DE CONEXION*************************/
			Conexion conexion = new Conexion();
				Connection con= null;
								
				try {
					DaoHoraGuardia daoHoraGuardia = new DaoHoraGuardia();
					ArrayList<HoraGuardia> lasHorasGuardia = daoHoraGuardia.mostrarHorasGuardia();
					
					for (int i=0; i<lasHorasGuardia.size(); i++) {
					System.out.print(lasHorasGuardia.get(i).getCod_profe_guardia() + " - ");
					System.out.print(lasHorasGuardia.get(i).getDia_semana() + " - ");
					System.out.print(lasHorasGuardia.get(i).getHora() + " - ");
					System.out.print(lasHorasGuardia.get(i).getFirmado());
					System.out.println();
					}
					
										
				} catch (SQLException se) {
					System.out.println(se.getMessage());
					
				}catch (Exception e) {
					e.printStackTrace();
				}

			}
	
}
