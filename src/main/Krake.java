package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;

public class Krake extends Kreis {
	Vektor richtung = new Vektor(1, 1);

	public Krake(Vektor pos, int r) {
		super(pos, r);
		for (int i = 0; i<=7; i++){
			tentakel[i] = new Tentakel(i,this.getRadius()); 
		}
	}

	Auge linkesAuge = new Auge(durchmesser, 30, Auge.Seite.LINKS);
	Auge rechtesAuge = new Auge(durchmesser, 35, Auge.Seite.RECHTS);
	Tentakel[] tentakel = new Tentakel[8];

	public void draw(Graphics g) {
		super.draw(g, new Color(150, 0, 150), position);
		for (int i = 0; i<=7; i++){
			tentakel[i].draw(g, new Color(150, 0, 150)); 
		}
		linkesAuge.draw(g, new Color(255, 255, 255), linkesAuge.position);
		rechtesAuge.draw(g, new Color(255, 255, 255), rechtesAuge.position);
	}

	public void move() {
		// Point mousePosition = MouseInfo.getPointerInfo().getLocation();
		position.x = position.x + richtung.x;
		position.y = position.y + richtung.y;
		richtung.drehen(3);
		for (int i = 0; i<=7; i++){
			tentakel[i].update(getMittelpunkt()); 
		}
		linkesAuge.update(this.position, richtung);
		rechtesAuge.update(this.position, richtung);
	}
}
