package listContact;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class  ListContact {
	
	//private ArrayList<ListContact>li;
	private String nom,visibilite,id_user;
	
	public static void main(String []args)
	{
		System.out.println();
	}
	
	public ListContact()
	{
		nom=new String();
		visibilite=new String();
		id_user=new String();
	}
	
	public ListContact(String n , String v, String id)
	{
		nom=n;
		visibilite=v;
		id_user=id;
	}
	
	public ListContact(String n )
	{
		nom=n;
		visibilite=new String();
		id_user=new String();
	}
	
	
	
	
	public static ArrayList<ListContact> ajoutList(ResultSet rs)
	{
		
		ArrayList<ListContact> uneListe=new ArrayList<ListContact>();
		try
		{
			while(rs.next())
			{
				//creer un object ListContact a partir d'une ligne du resultSet
				//uneListe.setNom(rs.getString("nom"));
				uneListe.add(new ListContact(rs.getString("nom")));
			}
			
			
		}
		
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return uneListe;
	}
	
	
	public String getNom()
	{
		return this.nom;
	}
	
	public void setNom(String nom)
	{
		this.nom=nom;
	}
	
}