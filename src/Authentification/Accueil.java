package Authentification;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Accueil
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Accueil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("login").equals("root"))
		{
			HttpSession session=request.getSession();
			if(request.getParameter("logout")==null)
			{
				session.setAttribute("login",request.getParameter("login"));
			}
			else
			{
				session.invalidate();
			}
			
			PrintWriter out=response.getWriter();
			out.println("Session cr��e !");
			out.println("Login: "+session.getAttribute("login"));
			
			out.println("<form method='post' action='Connect'>");
			out.println("<input type='submit' name='logout' value='logout'/>");
			out.println("<input type='hidden' name='msgExit' value='Vous avez �t� d�connect� !'/>");
			out.println("</form>");
		}
		
		else
		{
			PrintWriter out=response.getWriter();
			out.println("<form method='post' action='Connect'>");
			out.println("<input type='submit' name='logout' value='Accueil'/>");
			out.println("</form>");
		}
		
	}

}
