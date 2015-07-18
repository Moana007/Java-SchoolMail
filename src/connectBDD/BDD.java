package connectBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDD 
{
	private Connection conn=null;
	private Statement st=null;
	
	public void connect()
	{
		String url="jdbc:mysql://localhost:3306/schoolmail?user=root&password=";

		try 
		{ 
			Class.forName("com.mysql.jdbc.Driver"); 
			conn = DriverManager.getConnection(url); 
			st=conn.createStatement();
		
			//System.out.println(sql);
			//st.executeUpdate(sql);
		} 
		catch(ClassNotFoundException e) { 
			System.err.println("Driver non chargé !"); e.printStackTrace(); }
		catch(SQLException e) { 
			System.err.println("ErreurSQL !"); e.printStackTrace(); } 
		catch(Exception e){ System.err.println("Autres !");} 
	}
	
	public boolean executeInsert(String query)
	{
		try
		{
			return this.st.execute(query);
		}
		
		catch(SQLException e)
		{
			System.err.println(query);
			return false;
		}
	}

	
	public int executeUpdate(String query) 
	{
        try 
        {
            return st.executeUpdate(query);
        } 
        catch (SQLException e) 
        {
        	e.printStackTrace();
            System.err.println(e.getSQLState());
            System.err.println(e.getMessage());
            return -1;
        }
    }
	
	public ResultSet executeSelect(String query)
	{
		try
		{
			return st.executeQuery(query);
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	
	

}