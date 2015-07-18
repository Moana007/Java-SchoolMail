package gestion;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contact.Contact;
import connectBDD.BDD;
import listContact.ListContact;

/**
 * Servlet implementation class Gestion_liste
 */
@WebServlet("/Gestion_liste")
public class Gestion_liste extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Gestion_liste() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BDD bdd=new BDD();
		bdd.connect();
	    ResultSet rs=bdd.executeSelect("SELECT nom FROM lists");
	    
	    ArrayList<ListContact> l= ListContact.ajoutList(rs);
	    
	    
	    request.setAttribute("liste",l);
	    
		
		RequestDispatcher dispatConn = request.getRequestDispatcher("/jsp/gestion_list.jsp");
		dispatConn.forward(request,response);
	}

}