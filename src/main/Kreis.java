package main;

import java.awt.Color;
import java.awt.Graphics;

public class Kreis {
	Vektor position;
	int radius;

	public Kreis(Vektor pos, int r) {
		position = pos;
		radius = r;
	}

	public void draw(Graphics g, Color c, Vektor p) {
		g.setColor(c);
		g.fillOval((int) (position.x), (int) (position.y), radius, radius);
	}
}
