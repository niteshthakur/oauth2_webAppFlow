package com.nit.gooapi.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.api.services.plus.model.Person;
import com.nit.gooapi.json.GoogleTokenResponse;
import com.nit.gooapi.json.TokenHolder;

/**
 * Servlet implementation class OAUTHServlet
 */
public class OAUTHServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TokenHolder tokenHolder;
    /**
     * Default constructor. 
     */
    public OAUTHServlet() {
        	tokenHolder = new TokenHolder();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doGet() of OAUTHServlet");
		
		String authorizationCode = request.getParameter("code");
		String error = request.getParameter("error");
		System.out.println("Redirected by Google authorization server with parameteres" + authorizationCode);
		System.out.println("request URI = " + request.getRequestURL());
		//response.sendRedirect("/api/html/Thanks.html");
		if(error == null){
		
			
			
			HttpClient httpClient = new HttpClient();
			PostMethod postMethod = new PostMethod();
			postMethod.setParameter("code", authorizationCode);
			postMethod.setParameter("redirect_uri", "http://localhost:8090/api/OAUTHcallback");
			postMethod.setParameter("grant_type", "authorization_code");
			postMethod.setParameter("client_id", "123556217739-je0ulbcg453os615qeuh0kg7mfntt4g7.apps.googleusercontent.com");
			postMethod.setParameter("client_secret", "Anvx-WsTA4D1fLIJHf0s1a_p");
			postMethod.setPath("https://accounts.google.com/o/oauth2/token");
			httpClient.executeMethod(postMethod);
			System.out.println("Response Body = " + postMethod.getResponseBodyAsString());
			
			ObjectMapper mapper = new ObjectMapper();
			GoogleTokenResponse googleTokenResponse =  mapper.readValue(postMethod.getResponseBodyAsString(), GoogleTokenResponse.class);
			//tokenHolder.getTokenHolder().put(key, googleTokenResponse);
			
			//httpClient = new HttpClient();
			GetMethod getMethod = new GetMethod();
			String getPath = "https://www.googleapis.com/plus/v1/people/me" + "?access_token=" + googleTokenResponse.getAccess_token();
			getMethod.setPath(getPath);
			//getMethod.setRequestHeader("Authorization: Bearer", googleTokenResponse.getAccess_token());
			httpClient.executeMethod(getMethod);
			//Person googleUserProfile =  mapper.readValue(getMethod.getResponseBodyAsString(), Person.class);
			JsonNode node = mapper.readTree(getMethod.getResponseBodyAsString());
			
			System.out.println("******************RESPONSE FROM GOOGLE PLUS **********************/n" + getMethod.getResponseBodyAsString());
			
			
		    System.out.println("DISPLAY NAME = " + node.get("displayName"));
			
			response.sendRedirect("../api/html/Thanks.html");
			System.out.println("Access token retrived from google authorization server");
		
			
			
			
			
		}
		
		else{
			System.out.println("Error");
			response.sendRedirect("../api/html/Error.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In doPost() of OAUTHServlet");
	}

}
