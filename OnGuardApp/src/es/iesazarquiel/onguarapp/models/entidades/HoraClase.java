package es.iesazarquiel.onguarapp.models.entidades;

public class HoraClase {

	private String cod_profe_clase;
	private String dia_semana;
	private String hora;
	private String cod_aula;
	private String cod_asignatura;
	private String cod_grupo;
	
/***************************GETS & SETS*******************************************/	

	public String getCod_profe_clase() {
		return cod_profe_clase;
	}
	public void setCod_profe_clase(String cod_profe_clase) {
		this.cod_profe_clase = cod_profe_clase;
	}
	public String getDia_semana() {
		return dia_semana;
	}
	public void setDia_semana(String dia_semana) {
		this.dia_semana = dia_semana;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getCod_aula() {
		return cod_aula;
	}
	public void setCod_aula(String cod_aula) {
		this.cod_aula = cod_aula;
	}
	public String getCod_asignatura() {
		return cod_asignatura;
	}
	public void setCod_asignatura(String cod_asignatura) {
		this.cod_asignatura = cod_asignatura;
	}
	public String getCod_grupo() {
		return cod_grupo;
	}
	public void setCod_grupo(String cod_grupo) {
		this.cod_grupo = cod_grupo;
	}
	
	
}
