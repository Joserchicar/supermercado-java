package com.ipartek.formacion.controller.ejemplos;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieController
 */
@WebServlet("/CookieController")
public class CookieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// recoger parametros
		String recuerdame = request.getParameter("recuerdame");
		String email = request.getParameter("email");
				
		
		// Guardar una cookie con la ultima visita		
		LocalDateTime tiempo = LocalDateTime.now();
		String formattedDate = tiempo.format(DateTimeFormatter.ofPattern("dd-MMM-yyyy_HH:mm"));		
		Cookie cUltimaVisita = new Cookie("ultima_visita",formattedDate );
		
		cUltimaVisita.setMaxAge( 60 * 1 * 60 * 24 * 365  );  // 1 año
		response.addCookie(cUltimaVisita);
		
		
		// gestionar cookie del email		
		Cookie cEmail = new Cookie("cEmail", email );		
		if ( recuerdame != null ) {			
			cEmail.setMaxAge( 60 * 1 *60 *24 * 365  );  // 1 año
					
		}else{
			cEmail.setMaxAge(0);  // invalidar
			
		}		
		response.addCookie(cEmail);
		
		// recoger todas las cookies en el servidor
		// Cookie[] arrayGalletitas = request.getCookies();
		// para buscar una habria que hacer un for y buscar por su identificador
		
		
		// Ir a una vista	
		request.getRequestDispatcher("cookies.jsp").forward(request, response);
		
	}

}
