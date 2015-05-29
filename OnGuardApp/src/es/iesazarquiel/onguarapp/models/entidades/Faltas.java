package es.iesazarquiel.onguarapp.models.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Faltas {

	private String cod_profe_falta;
	private String dia_semana_falta;
	private String hora_falta;
	private Date fecha;
	private String cod_profe_guardia;
	private String dia_semana_guardia;
	private String hora_guardia;
	
	
/***************************GETS & SETS*******************************************/
	public String getCod_profe_falta() {
		return cod_profe_falta;
	}
	public void setCod_profe_falta(String cod_profe_clase) {
		this.cod_profe_falta = cod_profe_clase;
	}
	public String getDia_semana_falta() {
		return dia_semana_falta;
	}
	public void setDia_semana_falta(String dia_semana_falta) {
		this.dia_semana_falta = dia_semana_falta;
	}
	public String getHora_falta() {
		return hora_falta;
	}
	public void setHora_falta(String hora_falta) {
		this.hora_falta = hora_falta;
	}
	public String getCod_profe_guardia() {
		return cod_profe_guardia;
	}
	public void setCod_profe_guardia(String cod_profe_guardia) {
		this.cod_profe_guardia = cod_profe_guardia;
	}
	public String getDia_semana_guardia() {
		return dia_semana_guardia;
	}
	public void setDia_semana_guardia(String dia_semana_guardia) {
		this.dia_semana_guardia = dia_semana_guardia;
	}
	public String getHora_guardia() {
		return hora_guardia;
	}
	public void setHora_guardia(String hora_guardia) {
		this.hora_guardia = hora_guardia;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
/*********************   METODO FORMATEO DE FECHA    **********************************/
	
	public String getFechaNacimientoFormateada(){
		SimpleDateFormat formatoDeFecha=new SimpleDateFormat("dd-MM-yyyy");
		String fechaFormateada=formatoDeFecha.format((java.util.Date)fecha);
		return fechaFormateada;
		
	}
}
