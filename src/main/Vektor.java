package main;

public class Vektor {
	public float x;
	public float y;

	public Vektor(float a, float b) {
		x = a;
		y = b;
	}

	public Vektor() {
		this(0,0);
	}

	public void drehen(float gradwinkel) {
		double winkel = 2 * Math.PI * gradwinkel / (360); 
		//Vektor vektor = new Vektor(0, 0);
		float xNeu = (float) (x * Math.cos(winkel) - y * Math.sin(winkel));
		float yNeu = (float) (x * Math.sin(winkel) + y * Math.cos(winkel));
		this.x = xNeu;
		this.y = yNeu;
		//return vektor;
	}
}
