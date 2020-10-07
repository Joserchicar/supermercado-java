
package com.ipartek.formacion.ejemplos.modelo;

import java.util.List;

/**
 * Ejempo de DAO de un producto con dos funciones
 * 
 * {@code List<Producto> listarProductos()}
	
	{@code List<String> listarCategoriasProductos()}
	
 */

import com.ipartek.formacion.modelo.pojo.Producto;

public interface ActividadEjemploDAO {

	List<Producto> listarProductos();

	List<String> listarCategoriasProductos();

}
