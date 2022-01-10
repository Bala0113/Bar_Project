package bar;

import java.util.ArrayList;

public class Asztal {
	
	int asztalId;
	ArrayList<Ital> rendeles;

	public Asztal(int asztalId, ArrayList<Ital> rendeles) {
		super();
		this.asztalId = asztalId;
		this.rendeles = rendeles;
	}
	
	public void setLista(ArrayList<Ital> rendeles) {
		this.rendeles = rendeles;
	}
	public int getAsztalId() {
		return asztalId;
	}
	public ArrayList<Ital> getRendeles() {
		return rendeles;
	}
}
