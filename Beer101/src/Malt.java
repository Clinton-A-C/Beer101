
public class Malt {
	public int idMalt;
	public String MaltName;
	public double MaltQuanty;
	
	public int getIdMalt() {
		return idMalt;
	}
	public void setIdMalt(int idMalt) {
		this.idMalt = idMalt;
	}
	public String getMaltName() {
		return MaltName;
	}
	public void setMaltName(String maltName) {
		MaltName = maltName;
	}
	public double getMaltQuanty() {
		return MaltQuanty;
	}
	public void setMaltQuanty(double maltQuanty) {
		MaltQuanty = maltQuanty;
	}
	
	public double addMalt(double malt) {
		
		return malt + MaltQuanty;
		
	}
	
	public double subMalt(double malt) {
		
		return MaltQuanty - malt;
		
	}	
}
