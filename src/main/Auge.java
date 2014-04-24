package main;

import java.awt.Color;
import java.awt.Graphics;

public class Auge extends Kreis {
	Vektor abstand;

	public Auge(Vektor abstand, int radius, Vektor pos) {
		super(pos, radius);
		this.abstand = abstand;
	}

	public Auge(Vektor abstand, int radius) {
		super(radius);
		this.abstand = abstand;
	}

	Pupille pupille = new Pupille(position, 10, new Vektor(10, 10));

	public void update(Vektor krakenPosition) {
		position.x = krakenPosition.x + abstand.x;
		position.y = krakenPosition.y + abstand.y;
	}

	public void draw(Graphics g, Color c, Vektor p) {
		super.draw(g, c, p);
		pupille.draw(g, new Color(0, 0, 0), pupille.position);
	}
}