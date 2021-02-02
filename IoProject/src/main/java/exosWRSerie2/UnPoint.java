package exosWRSerie2;

import java.io.Serializable;

public class UnPoint implements Serializable{

	private int abscisse,ordonnee;
	
	public UnPoint(int a,int b) {
		abscisse=a;
		ordonnee=b;
	}
	
	public void translation (int dx, int dy) {
		abscisse+=dx;
		ordonnee+=dy;
	}

	@Override
	public String toString() {
		return "UnPoint [abscisse=" + abscisse + ", ordonnee=" + ordonnee + "]";
	}
	
	
	
}
