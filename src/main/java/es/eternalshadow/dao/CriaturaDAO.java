package es.eternalshadow.dao;

import java.util.List;

import es.eternalshadow.entities.Criatura;

public interface CriaturaDAO {
	
	//definir los metodos para el CRUD de Criatura
	
	
	// Crear criatura
	public void guardarCriatura(Criatura criatura);
	
	// Eliminar criatura por id
	public void eliminarCriatura(Long id);
	
	// Actualizar criatura
	public void actualizarCriatura(Criatura criatura);
	
	// Obtener criatura por id
	public Criatura obtenerCriaturaPorId(Long id);
	
	// Obtener todas las criaturas
	public List<Criatura> obtenerTodasLasCriaturas();
	
	

}
