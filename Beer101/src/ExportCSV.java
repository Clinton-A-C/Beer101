import java.awt.Desktop;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ExportCSV {

	void malt() {
		try {
			
			DatabaseConn con = new DatabaseConn();
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
			
			PrintWriter pw = new PrintWriter(new File(timeStamp + "_Malt.csv"));
	        StringBuilder sb = new StringBuilder();
	        sb.append("idMalt");
	        sb.append(',');
	        sb.append("MaltName");
	        sb.append(',');
	        sb.append("MaltQuanty");
	        sb.append('\n');
	        
	        
			ArrayList<Malt> theMaltList = con.getMalt();
	        
	        for (int i = 0; i < theMaltList.size(); i++) {
				
					        
	        sb.append(theMaltList.get(i).getIdMalt());
	        sb.append(',');
	        sb.append(theMaltList.get(i).getMaltName());
	        sb.append(',');
	        sb.append(theMaltList.get(i).getMaltQuanty());
	        sb.append('\n');
	        }
	        pw.write(sb.toString());
	        pw.close();
	        Desktop.getDesktop().open(new File(timeStamp + "_Malt.csv"));
	        System.out.println("done!");
		
	} catch(Exception e) { 
		System.out.println(e);
	}
		}
	}
