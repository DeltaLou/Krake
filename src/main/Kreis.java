package main;

import java.awt.Color;
import java.awt.Graphics;

public class Kreis {
	Vektor position;
	int durchmesser;

	public Kreis(Vektor pos, int r) {
		position = pos;
		durchmesser = r;
	}

	public Kreis(int r) {
		durchmesser = r;
		position = new Vektor(0, 0);
	}
	public Kreis(){
		durchmesser = 0;
		position = new Vektor(0,0);
	}

	public void draw(Graphics g, Color c, Vektor p) {
		g.setColor(c);
		g.fillOval((int) (position.x), (int) (position.y), durchmesser, durchmesser);
	}
}
