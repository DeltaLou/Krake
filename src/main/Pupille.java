package main;

import java.awt.Color;
import java.awt.Graphics;

public class Pupille extends Kreis {
	Vektor abstand;

	public Pupille(Vektor a, int r, Vektor b) {
		super(a, r);
		abstand = b;
	}

	public void update(Vektor augenPosition) {
		position.x = augenPosition.x + abstand.x;
		position.y = augenPosition.y + abstand.y;
	}

	public void draw(Graphics g, Color c, Vektor p) {
		super.draw(g, c, p);
	}
}