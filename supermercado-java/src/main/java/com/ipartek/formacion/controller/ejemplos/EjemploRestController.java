package com.ipartek.formacion.controller.ejemplos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EjemploRestController
 */
@WebServlet("/Ejemplo-Rest")
public class EjemploRestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjemploRestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/jason");
		response.setCharacterEncoding("UTF-8");
		
		// La respuesta en el body
		
		PrintWriter out=response.getWriter();	
		
		
		
		/*
		 * {
   				"id": 5,
   				"nombre": "Gazpacho",
   				"precio": 2.34
   			}
    */
		
		
	out.print("{");
		out.print("\"id\": 5,");
		out.print("\"nombre\": \"Gazpacho\",");
		out.print("\"precio\": 2.34");
	out.print("}");
		
	// vaciar buffer
	
		out.flush();
		
		// Codido de estado, TODO usar constante
					response.setStatus(200);
		

}
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
