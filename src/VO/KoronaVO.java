package VO;

public class KoronaVO {
	private String name;
	private String Confirmation;
	private String Dead;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConfirmation() {
		return Confirmation;
	}
	public void setConfirmation(String confirmation) {
		Confirmation = confirmation;
	}
	public String getDead() {
		return Dead;
	}
	public void setDead(String dead) {
		Dead = dead;
	}
	@Override
	public String toString() {
		return "KoronaVO [name=" + name + ", Confirmation=" + Confirmation + ", Dead=" + Dead + "]";
	}
	
}
