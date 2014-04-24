package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;

public class Krake extends Kreis {
	Vektor richtung = new Vektor(1, 1);

	public Krake(Vektor pos, int r) {
		super(pos, r);
	}

	Auge linkesAuge = new Auge(new Vektor(5, 20), 30);
	Auge rechtesAuge = new Auge(new Vektor(30, 20), 30);

	public void draw(Graphics g) {
		super.draw(g, new Color(150, 0, 150), position);
		linkesAuge.update(this.position);
		rechtesAuge.update(this.position);
		linkesAuge.draw(g, new Color(255, 255, 255), linkesAuge.position);
		rechtesAuge.draw(g, new Color(255, 255, 255), rechtesAuge.position);
	}

	public void move() {
		// Point mousePosition = MouseInfo.getPointerInfo().getLocation();

		position.x = position.x + richtung.x;
		position.y = position.y + richtung.y;
		richtung = richtung.drehen(3);
	}
}
