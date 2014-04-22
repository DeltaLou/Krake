package main;

public class Vektor {
	public float x;
	public float y;

	public Vektor(float a, float b) {
		x = a;
		y = b;
	}

	public Vektor drehen(float gradwinkel) {
		double winkel = 2 * Math.PI * gradwinkel / (360);
		Vektor vektor = new Vektor(0, 0);
		vektor.x = (float) (x * Math.cos(winkel) - y * Math.sin(winkel));
		vektor.y = (float) (x * Math.sin(winkel) + y * Math.cos(winkel));
		return vektor;
	}
}
