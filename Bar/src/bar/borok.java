package bar;

public class borok extends Ital {

	fajtak fajta;

	public fajtak getFajta() {
		return fajta;
	}

	public void setFajta(fajtak fajta) {
		this.fajta = fajta;
	}

	public borok(String nev, Integer ar, String ar1, String mennyiseg, fajtak fajta) {
		super(nev, ar, ar1, mennyiseg);
		this.fajta = fajta;
	}
	
	
	
}
