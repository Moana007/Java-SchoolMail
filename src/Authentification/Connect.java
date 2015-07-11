package Authentification;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Connect
 */
@WebServlet("/Connect")
public class Connect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Connect() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*PrintWriter out=response.getWriter();
		
		out.println("<form method='post' action='Accueil'>");
		out.println("Login : <input type='text' name='login' value='' />");
		out.println("Password : <input type='password' name='age' value='' />");
		out.println("<input type='submit' name='valider' value='OK' />");
		out.println("</form>");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*PrintWriter out=response.getWriter();
		if(request.getParameter("msgExit") !=null)
		{
		out.println(request.getParameter("msgExit"));
		}
		
		out.println("<form method='post' action='Accueil'>");
		out.println("Login : <input type='text' name='login' value='' />");
		out.println("Password : <input type='password' name='age' value='' />");
		out.println("<input type='submit' name='valider' value='OK' />");
		out.println("</form>");*/
	}

}
