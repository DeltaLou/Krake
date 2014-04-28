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

	public Auge(int krakenRadius, int augenRadius, String seite) {
		super(augenRadius);
		abstand = new Vektor();
		if (seite == "links") {
			abstand.x = (2 * krakenRadius / 7 - augenRadius / 2);
		}
		if (seite == "rechts") {
			abstand.x = 5 * krakenRadius / 7 - augenRadius / 2;
		}
		abstand.y = 12 * krakenRadius / 25 - augenRadius / 2;
	}

	Pupille pupille = new Pupille(new Vektor(15, 15), 10);

	public void update(Vektor krakenPosition) {
		position.x = krakenPosition.x + abstand.x;
		position.y = krakenPosition.y + abstand.y;
		pupille.update(position);
	}

	public void draw(Graphics g, Color c, Vektor p) {
		super.draw(g, c, p);
		pupille.draw(g, new Color(0, 0, 0), pupille.position);
	}
}