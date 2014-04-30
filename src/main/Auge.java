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

	public Auge(int krakenDurchmesser, int augenDurchmesser, Seite seite) {
		super(augenDurchmesser);
		abstand = new Vektor();
		if (seite == Seite.LINKS) {
			abstand.x = (2 * krakenDurchmesser / 7 - augenDurchmesser / 2);
		}
		if (seite == Seite.RECHTS) {
			abstand.x = 5 * krakenDurchmesser / 7 - augenDurchmesser / 2;
		}
		abstand.y = 12 * krakenDurchmesser / 25 - augenDurchmesser / 2;
	}

	// Pupille pupille = new Pupille(new Vektor(15, 15), 10);
	Pupille pupille = new Pupille(durchmesser, 50);

	public void update(Vektor krakenPosition, Vektor richtung) {
		position.x = krakenPosition.x + abstand.x;
		position.y = krakenPosition.y + abstand.y;
		pupille.update(position, richtung);
	}

	public void draw(Graphics g, Color c, Vektor p) {
		super.draw(g, c, p);
		pupille.draw(g, new Color(0, 0, 0), pupille.position);
	}
}