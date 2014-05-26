package main;

import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;

public class Tentakel {
	Vektor abstand = new Vektor();
	Vektor pos = new Vektor();
	int nummer;
	int armLängenZahl = 10;

	public Tentakel(int num, int krakenRadius) {
		this.nummer = num;
		abstand.x = 0;
		abstand.y = -krakenRadius;
		abstand.drehen(109 + 20 * nummer);
		int r = krakenRadius / 5;
		for (int i = 0; i < armLängenZahl; i++) {
			armKreis[i] = new Kreis(new Vektor(), r - i);
		}
	}

	Kreis[] armKreis = new Kreis[armLängenZahl];
	Vektor position = new Vektor();
	Vektor kuVe = new Vektor();
	int j= 0;

	public void update(Vektor krakenPosition) {
		pos.x = krakenPosition.x + abstand.x;
		pos.y = krakenPosition.y + abstand.y;
		armKreis[0].mittelpunkt.x = pos.x;
		armKreis[0].mittelpunkt.y = pos.y;
			
		for (int i = 1; i < armLängenZahl; i++) {
			j=j+1;
			armKreis[i].mittelpunkt.x = armKreis[0].mittelpunkt.x + (float)Math.sin(i * 1.5+j/70.0)*3;
			armKreis[i].mittelpunkt.y = armKreis[i-1].mittelpunkt.y - armKreis[i].radius;
		}
		for (int i = 1; i < armLängenZahl; i++) {
			//arme zum nullpunkt verschieben, drehen, zurück verschieben
			armKreis[i].mittelpunkt.x = armKreis[i].mittelpunkt.x-pos.x;
			armKreis[i].mittelpunkt.y = armKreis[i].mittelpunkt.y-pos.y;
			armKreis[i].mittelpunkt.drehen(109 + 20 * nummer);
			armKreis[i].mittelpunkt.x = armKreis[i].mittelpunkt.x+pos.x;
			armKreis[i].mittelpunkt.y = armKreis[i].mittelpunkt.y+pos.y;

		}
	}

	float tentakelBreite = 30;

	public void draw(Graphics g, Color c) {

		for (int i = 0; i < armLängenZahl; i++) {
			armKreis[i].draw(g, c);
		}
	}
}
