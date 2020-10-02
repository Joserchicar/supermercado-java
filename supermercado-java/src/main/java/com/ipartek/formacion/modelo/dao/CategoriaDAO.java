package com.ipartek.formacion.modelo.dao;

import java.util.ArrayList;

import com.ipartek.formacion.modelo.CrudAble;
import com.ipartek.formacion.modelo.pojo.Categoria;

public interface CategoriaDAO extends CrudAble<Categoria> {

	/**
	 * Hereda los metodos basicos de la interfaz CrudAble Obtiene todas las
	 * categorias con sus productos asociados
	 * 
	 * @return {@code ArrayList<Categoria>} ordenadas alfabeticamente
	 * @author Joserra
	 * @version 1.0
	 */
	public ArrayList<Categoria> getAllWithProducts();

}
