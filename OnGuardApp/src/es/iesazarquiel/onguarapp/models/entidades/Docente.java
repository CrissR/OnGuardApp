package es.iesazarquiel.onguarapp.models.entidades;

public class Docente {
	private String cod_profe;
	private String nombre;
	private String apellidos;
	private String tipo;
	private String usuario;
	private String contrasenia;

/*********************************GETS & SETS*****************************************************/
	public String getCod_profe() {
		return cod_profe;
	}
	public void setCod_profe(String cod_profe) {
		this.cod_profe = cod_profe;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	


}
