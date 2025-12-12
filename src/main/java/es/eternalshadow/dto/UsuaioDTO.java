package es.eternalshadow.dto;

import java.sql.Date;

public class UsuaioDTO {

	private int id;
	private String username;
	private String email;
	private String password;
	private String rol;
	private Date fechaAlta;
	private boolean activo;
	
	// Constructor vacío
	public UsuaioDTO() {
	}
	
	// Constructor con parámetros completo
	public UsuaioDTO(int id, String username, String email, String password,
			String rol, Date fechaAlta, boolean activo) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.rol = rol;
		this.fechaAlta = fechaAlta;
		this.activo = activo;
	}
	
	// Constructo con parámetros sin id
	public UsuaioDTO(String username, String email, String password,
			String rol, Date fechaAlta, boolean activo) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.rol = rol;
		this.fechaAlta = fechaAlta;
		this.activo = activo;
	}
	//constructor solo  username, email
	public UsuaioDTO(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", email="
				+ email + ", password=" + password + ", rol=" + rol
				+ ", fechaAlta=" + fechaAlta + ", activo=" + activo + "]";
	}
}
