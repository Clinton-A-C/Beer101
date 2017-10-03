import java.util.ArrayList;
import java.util.Scanner;

public class Beer101 {
	static DatabaseConn con = null;
	static Scanner reader = null;
	public static void main(String[] args) {
		
		con = new DatabaseConn();
		
		boolean running = true;
		int userIN = 0;
		
		while (running) {
			
			reader = new Scanner(System.in);
			System.out.print("Enter number to to enter product mangement (1 Malt, 2 Hop, 2 Salt): ");
			userIN = reader.nextInt();
			if (userIN == 1) {
				maltMangement();				
				
			} else if (userIN == 2) {
				
				ArrayList<Hop> theHopList = con.getHop();
		        
		        for (int i = 0; i < theHopList.size(); i++) {
					System.out.println(theHopList.get(i).getHopName());
				}
				
			} else if (userIN == 3) {
				con = new DatabaseConn();
				ArrayList<Salt> theSaltList = con.getSalt();
		        
		        for (int i = 0; i < theSaltList.size(); i++) {
					System.out.println(theSaltList.get(i).getSaltName());
				}
				
			} else {
				running = false;
			}
			
		}

        
        
        // Can display all Malts, Hops and Salts.
        // need loop to display profiles
        // Need to create beer profiles
        
       	
	}

	static void maltMangement()  {
		
		boolean running = true;
		int userIN = 0;
		
		while (running) {
			
			reader = new Scanner(System.in);
			System.out.print("Enter number to perform action (1 Display Malts, 2 Export Malts to CSV, 2 Salt): ");
			userIN = reader.nextInt();
			if (userIN == 1) {
				ArrayList<Malt> theMaltList = con.getMalt();
		        
		        for (int i = 0; i < theMaltList.size(); i++) {
					System.out.println(theMaltList.get(i).getMaltName());
				}				
				
			} else if (userIN == 2) {
				ExportCSV exportCSV = new ExportCSV();
				exportCSV.malt();
				
			} else {
				running = false;
			}
		
		}
	}

}
