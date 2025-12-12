package es.eternalshadow.dao;

import java.util.List;

import es.eternalshadow.entities.Raza;

public interface RazaDAO {
	
	//definir los metodos para el CRUD de Raza
	
	// Crear raza
	public void guardarRaza(Raza raza);
	
	// Eliminar raza por id
	public void eliminarRaza(int id);
	
	// Actualizar raza
	public void actualizarRaza(Raza raza);
	
	// Obtener raza por id
	public Raza obtenerRazaPorId(int id);
	
	// Obtener todas las razas
	public List<Raza> obtenerTodasLasRazas();
	

}
