package main;

import java.awt.Color;
import java.awt.Graphics;

public class Pupille extends Kreis {
	Vektor abstand;

	public Pupille(Vektor abstand, int r, Vektor pos) {
		super(pos, r);
		this.abstand = abstand;
	}

	public Pupille(Vektor abstand, int r) {
		super(r);
		this.abstand = abstand;
	}

	public void update(Vektor augenPosition, Vektor richtung) {
		position.x = augenPosition.x + abstand.x + richtung.x;
		position.y = augenPosition.y + abstand.y + richtung.y;
		/*
		 * System.out.println("augenPosition: " + augenPosition.x + ", " +
		 * augenPosition.y); System.out.println("Position: " + position.x + ", "
		 * + position.y); System.out.println("abstand: " + abstand.x + ", " +
		 * abstand.y);
		 */
	}

	public void draw(Graphics g, Color c, Vektor p) {
		super.draw(g, c, p);
	}
}