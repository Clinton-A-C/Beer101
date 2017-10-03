import java.sql.*;
import java.util.ArrayList;

public class DatabaseConn {
	Connection con = null;
	Statement stmt= null;
	ResultSet rs;
	
	public String[] malts;
	public String[] hops;
	
	void startConn() {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Beer101?verifyServerCertificate=false&useSSL=true","beer101Service","beer101");
			stmt=con.createStatement();
		} catch(Exception e) { 
			System.out.println(e);
		}  
	}
	
	void endConn() {
		try {
			con.close();  
		} catch(Exception e) {
			System.out.println(e);
		}   
	}

	public ArrayList<Malt> getMalt() {
		
		ArrayList<Malt> theMaltList = null;
		
		try {
			startConn();
			rs = stmt.executeQuery("SELECT * FROM beer101.malt;");
				
			theMaltList = new ArrayList<Malt>(); 
			
			while(rs.next()) {  
				
				Malt malt = new Malt();
				malt.setIdMalt(rs.getInt(1));
				malt.setMaltName(rs.getString(2));
				malt.setMaltQuanty(rs.getDouble(3)); 
				theMaltList.add(malt);
			}
			endConn();
		} catch(Exception e) { 
			System.out.println(e);
		} 
			
		return theMaltList;
	}

	public ArrayList<Hop> getHop() {
		
		ArrayList<Hop> theHopList = null;
		
		try {
			startConn();
			rs = stmt.executeQuery("SELECT * FROM beer101.hop;");
				
			theHopList = new ArrayList<Hop>(); 
			
			while(rs.next()) {  
				
				Hop hop = new Hop();
				hop.setIdHop(rs.getInt(1));
				hop.setHopName(rs.getString(2));
				hop.setHopQuanty(rs.getDouble(3)); 
				theHopList.add(hop);
			}
			endConn();
		} catch(Exception e) { 
			System.out.println(e);
		} 
			
		return theHopList;
	}

	public ArrayList<Salt> getSalt() {
		
		ArrayList<Salt> theSaltList = null;
		
		try {
			startConn();
			rs = stmt.executeQuery("SELECT * FROM beer101.salt;");
				
			theSaltList = new ArrayList<Salt>(); 
			
			while(rs.next()) {  
				
				Salt salt = new Salt();
				salt.setIdSalt(rs.getInt(1));
				salt.setSaltName(rs.getString(2));
				salt.setSaltQuanty(rs.getDouble(3)); 
				theSaltList.add(salt);
			}
			endConn();
		} catch(Exception e) { 
			System.out.println(e);
		} 
			
		return theSaltList;
	}


}

