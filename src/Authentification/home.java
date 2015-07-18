package Authentification;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectBDD.BDD;

/**
 * Servlet implementation class home
 */
@WebServlet("/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public home() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatConn = request.getRequestDispatcher("/connect");
    	BDD bdd = new BDD();
    	bdd.connect();
    

		
		// CONNEXION
		if(request.getParameter("form").equals("connexion")){
			if(request.getParameter("nom").equals("") || request.getParameter("mdp").equals("")) { // si champ vide
				request.setAttribute("state", "champ_vide");
				dispatConn.forward(request,response);
			}
			else {
				String field_nom = request.getParameter("nom");
				String field_mdp = request.getParameter("mdp");
				
				ResultSet test = bdd.executeSelect("SELECT id,login,password,statut FROM users WHERE login ='"+field_nom+"'");
				
				if (test != null) {
					Integer id = 0; String login = ""; String pwd = ""; String statut = "";
			    	try {
						while(test.next()){
							id = test.getInt("id");
							login = test.getString("login");
							pwd = test.getString("password");
							statut = test.getString("statut");
						}
					} catch (SQLException e) {e.printStackTrace();}
				
					if(md5(field_mdp).equals(pwd)){ // TODO : Verif BDD AVEC md5
						if(request.getParameter("logout") == null){

							HttpSession session=request.getSession();
							session.setAttribute("user_id", id);
							session.setAttribute("user_login", login);
							session.setAttribute("user_statut", statut);
							
							getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request,response);
						}
					}
					else {
						request.setAttribute("state", "mauvais_identifiants");
						dispatConn.forward(request,response);
					}
		    	}
				else {
					request.setAttribute("state", "mauvais_identifiants");
					dispatConn.forward(request,response);
				}
			}
		}
		//INSCRIPTION		
		else if(request.getParameter("form").equals("inscription")){ 	
			if(request.getParameter("nom").equals("") || request.getParameter("mdp").equals("") ||  request.getParameter("role").equals("")){ //si champ vide
				request.setAttribute("state", "champ_vide");
				dispatConn.forward(request,response);
			}
			else if(!request.getParameter("mdp").equals(request.getParameter("mdp2"))) { // Si les mdp ne correspondent pas
				request.setAttribute("state", "mdp_differents");
				dispatConn.forward(request,response);
			}
			else if(request.getParameter("nom").length() < 4 || request.getParameter("mdp").length() < 4) {
				request.setAttribute("state", "trop_court");
				dispatConn.forward(request,response);
			}
			else {
				String nom = request.getParameter("nom");
				String mdp = md5(request.getParameter("mdp")); //cripté avec la function md5()
				String statut = request.getParameter("role");
				
				bdd.executeInsert("INSERT INTO users(login,password,statut) VALUES('"+nom+"','"+mdp+"','"+statut+"')");
				
				ResultSet test2 = bdd.executeSelect("SELECT id,login,statut FROM users WHERE login ='"+nom+"'");
				
				if (test2 != null) {
			    	try {
						while(test2.next()){
							HttpSession session=request.getSession();
							session.setAttribute("user_id", test2.getInt("id"));
							session.setAttribute("user_login", test2.getString("login"));
							session.setAttribute("user_statut", test2.getString("statut"));
						}
					} catch (SQLException e) {e.printStackTrace();}
			    	
					request.setAttribute("state","inscription");
					getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request,response);	
				}
			}
		}
		
		// TODO: ICI LE CODE QUI AFFICHERA DES TRUCKS SUR LA PAGE D'ACCUEIL	

	}

	public static String md5(String input) {
        String md5 = null;
        if(null == input) return null;
        try {
        //Create MessageDigest object for MD5
        MessageDigest digest = MessageDigest.getInstance("MD5");
        //Update input string in message digest
        digest.update(input.getBytes(), 0, input.length());
        //Converts message digest value in base 16 (hex) 
        md5 = new BigInteger(1, digest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }

//	public static boolean isEmailAdress(String email){
//		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
//		Matcher m = p.matcher(email.toUpperCase());
//		return m.matches();
//	}
//	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
