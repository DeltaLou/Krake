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

	public Pupille(int augenRadius, int pupillenFaktor) {
		radius = augenRadius * pupillenFaktor / 100;
		System.out.println(radius);
		abstand = new Vektor();
		//abstand.x = augenRadius - radius;
		//abstand.y = augenRadius - radius;

	}

	public void update(Vektor augenMittelpunkt, Vektor richtung) {
		mittelpunkt.x = augenMittelpunkt.x + radius / 2 * richtung.x;
		mittelpunkt.y = augenMittelpunkt.y + radius / 2 * richtung.y;
		/*
		 * System.out.println("augenPosition: " + augenPosition.x + ", " +
		 * augenPosition.y); System.out.println("Position: " + position.x + ", "
		 * + position.y); System.out.println("abstand: " + abstand.x + ", " +
		 * abstand.y);
		 */
	}

	public void draw(Graphics g, Color c) {
		super.draw(g, c);
	}
}