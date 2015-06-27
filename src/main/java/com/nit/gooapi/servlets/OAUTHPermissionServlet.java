package com.nit.gooapi.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OAUTHPermissionServlet
 */
public class OAUTHPermissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OAUTHPermissionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doGet() of OAUTHPermissionServlet");
		String qString = "?client_id=123556217739-je0ulbcg453os615qeuh0kg7mfntt4g7.apps.googleusercontent.com&redirect_uri=http://localhost:8090/api/OAUTHcallback&response_type=code&scope=https://www.googleapis.com/auth/calendar https://www.googleapis.com/auth/plus.profile.emails.read&approval_prompt=force";
		response.sendRedirect("https://accounts.google.com/o/oauth2/auth" + qString);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
