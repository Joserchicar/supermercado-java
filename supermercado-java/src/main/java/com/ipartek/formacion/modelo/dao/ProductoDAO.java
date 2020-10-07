package com.ipartek.formacion.modelo.dao;

import java.util.ArrayList;

import com.ipartek.formacion.modelo.CrudAble;
import com.ipartek.formacion.modelo.pojo.Producto;
import com.ipartek.formacion.modelo.pojo.ResumenUsuario;

/**
 * Hereda los metodos basicos de la interfaz CrudAble Ademas definie un nuevo:
 * {@code ArrayList<Producto> getAllByNombre( String nombre )}"
 * 
 * @author Joserra
 * @version 1.0
 *
 */
public interface ProductoDAO extends CrudAble<Producto> {

	/**
	 * Validamos el producto para que sea visible en la parte publica
	 * 
	 * @param id identificador del producto
	 * 
	 */
	void validar(int id);

	/**
	 * Eliminar un registro, pero comprobamos que pertenezca a un usuario
	 * 
	 * @param idProducto la id que tiene el producto a borrar
	 * @param idUsuario  la id del usuario al que pertenece el producto a borrar
	 * @return Producto eliminado
	 * @throws SeguridadException Si no puede eliminar el producto porque no
	 *                            pertenece al usuario
	 * @throws Exception          e. cualquier otra excepcion, id incorrecta, no
	 *                            existre el producto
	 */
	Producto delete(int idProducto, int idUsuario) throws Exception, SeguridadException;

	/**
	 * Comprueba que el Producto pertenezca al Usuario
	 * 
	 * @param idProducto int la id del producto que se utiliza
	 * @param idUsuario  int la id del usuario al que pertenece el producto
	 * @return Producto pertenecinte al idUsuario
	 * @throws Exception          cualquier excepcion sobe la existencia del usuario
	 *                            o producto, las id deben de ser valida
	 * @throws SeguridadException si no pertenece el producto al Usuario
	 */
	Producto checkSeguridad(int idProducto, int idUsuario) throws Exception, SeguridadException;

	/**
	 * 
	 * @param nombre String nombre del producto por el que se va a buscar. puede ser
	 *               una parte del nombre completo
	 * @return ArrayList de Productos que contienen el nombre
	 */
	ArrayList<Producto> getAllByNombre(String nombre);

	/**
	 * Obtiene todos los productos de un usuario, estos pueden estar validados o no
	 * 
	 * @param idUsuario  int identificador del usuario
	 * @param isValidado boolean true para mostrar los productos con
	 *                   fecha_validacion, false para mostrar los pendientes de
	 *                   validar
	 * @return ArrayList de productos que pertenece a un usuario
	 */
	ArrayList<Producto> getAllByUser(int idUsuario, boolean isValidado);

	/**
	 * Obtiene los ultimos registros ordenador por id descentente
	 * 
	 * @param numReg int numero de registros a recuperar
	 * @return ArrayList de Producto
	 */
	ArrayList<Producto> getLast(int numReg);

	/**
	 * Obtienes los productos de una Categoria
	 * 
	 * @param idCategoria int identificador de la Categoria
	 * @param numReg      int numero de registgros a mostrar
	 * @return ArrayList de Producto
	 */
	ArrayList<Producto> getAllByCategoria(int idCategoria, int numReg);

	/**
	 * 
	 * @param precioMinimo int, indica el precio minimo valido
	 * @param precioMaximo int, indica el precio maximo valido
	 * @return ArrayList de productos cuyo precio se encuentre dentro de esos
	 *         parametros
	 * @throws Exception si el precio esta por debajo o por encima de los parametros
	 */
	ArrayList<Producto> getAllRangoPrecio(int precioMinimo, int precioMaximo) throws Exception;

	/**
	 * Obtiene datos estadisticos del Usuario y sus productos
	 * 
	 * @param idUsuario .int es el id del usuario del que se muestran los datos
	 * @see ResumenUsuario pojo donde se guardan los datos estadisticos de os
	 *      usuarios
	 * @return ResumenUsuario
	 */
	ResumenUsuario getResumenByUsuario(int idUsuario);

	/**
	 * Modifica un producto un Usuario normal, el cual no es Administrador. El
	 * producto vuelve a estar pendiente de Validación
	 * 
	 * @param p Producto
	 * @return Producto validado
	 * @throws Exception          recoge los errores que pueden surgir al introducir
	 *                            los nuevos datos
	 * @throws SeguridadException recoge errores de validacion por persona no
	 *                            autorizada
	 */
	Producto updateByUser(Producto p) throws Exception, SeguridadException;

}
