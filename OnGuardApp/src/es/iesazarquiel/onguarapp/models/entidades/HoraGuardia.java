package es.iesazarquiel.onguarapp.models.entidades;

public class HoraGuardia {

	private String cod_profe_guardia;
	private String dia_semana;
	private String hora;
	private String firmado;


/***************************GETS & SETS*******************************************/	
	public String getCod_profe_guardia() {
		return cod_profe_guardia;
	}
	public void setCod_profe_guardia(String cod_profe_guardia) {
		this.cod_profe_guardia = cod_profe_guardia;
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
	public String getFirmado() {
		return firmado;
	}
	public void setFirmado(String firmado) {
		this.firmado = firmado;
	}
}
