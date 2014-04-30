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
	
	public Pupille(int augenDurchmesser, int pupillenDurchmesser) {
		super(pupillenDurchmesser);
		//int pupillenDurchmesser = (int) (pupillenFaktor);
		abstand = new Vektor();
		abstand.x = augenDurchmesser/2 - pupillenDurchmesser/2;
		abstand.y = augenDurchmesser/2 - pupillenDurchmesser/2;
		
	}


	public void update(Vektor augenPosition, Vektor richtung) {
		position.x = augenPosition.x + abstand.x + abstand.x/3 * richtung.x;
		position.y = augenPosition.y + abstand.y + abstand.x/3 * richtung.y;
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