package com.ipartek.formacion.controller.backoffice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class InicioController
 * 
 * Ciontrolador del inicio del interfaz del Administrador
 * 
 */
@WebServlet("/views/backoffice/inicio")
public class InicioBackOfficeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final static Logger LOG = Logger.getLogger(InicioBackOfficeController.class);

	/**
	 * Se encarga de listar, o mostrar una los datos de los productos validados o
	 * sin validar, los usuarios existentes u los productos de cada usuario
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO recueprar datos de inicio para el usuario

		request.setAttribute("numero_productos", 34578);
		request.setAttribute("numero_usuarios", 10000);
		request.setAttribute("numero_logeados", 456);
		request.setAttribute("productos_pendientes", 2);

		String pagina = "index.jsp";
		LOG.debug("forward: " + pagina);

		request.getRequestDispatcher(pagina).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
