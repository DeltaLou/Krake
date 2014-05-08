package main;

import java.awt.Color;
import java.awt.Graphics;

public class Auge extends Kreis {
	Vektor abstand;

	public enum Seite {
		LINKS, RECHTS
	}

	public Auge(Vektor abstand, int durchmesser, Vektor pos) {
		super(pos, durchmesser);
		this.abstand = abstand;
	}

	public Auge(Vektor abstand, int durchmesser) {
		super(durchmesser);
		this.abstand = abstand;
	}

	public Auge(int krakenRadius, int augenRadius, Seite seite) {
		super(augenRadius);
		abstand = new Vektor();
		if (seite == Seite.LINKS) {
			abstand.x = -(krakenRadius / 2- augenRadius/7);
		}
		if (seite == Seite.RECHTS) {
			abstand.x = (krakenRadius /2 - augenRadius/7);
		}
		abstand.y = - krakenRadius/25;
	}

	// Pupille pupille = new Pupille(new Vektor(15, 15), 10);
	Pupille pupille = new Pupille(radius, 50);

	public void update(Vektor krakenPosition, Vektor richtung) {
		mittelpunkt.x = krakenPosition.x + abstand.x;
		mittelpunkt.y = krakenPosition.y + abstand.y;
		pupille.update(mittelpunkt, richtung);
	}

	public void draw(Graphics g, Color c, Vektor p) {
		super.draw(g, c, p);
		pupille.draw(g, new Color(0, 0, 0), pupille.mittelpunkt);
	}
}