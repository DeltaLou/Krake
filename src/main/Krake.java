package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Random;

public class Krake extends Kreis {
	Vektor richtung = new Vektor(1, 1);

	public Krake(Vektor pos, int r) {
		super(pos, r);
		for (int i = 0; i<=7; i++){
			tentakel[i] = new Tentakel(i,körper.getRadius()); 
		}


	}

	Auge linkesAuge = new Auge(radius, 30, Auge.Seite.LINKS);
	Auge rechtesAuge = new Auge(radius, 35, Auge.Seite.RECHTS);
	Tentakel[] tentakel = new Tentakel[8];
	Körper körper = new Körper(mittelpunkt, radius);
	int randWinkel=3;
	int i = 0;
	Random randomGenerator = new Random();
	int randSchleife = randomGenerator.nextInt(30);


	public void draw(Graphics g) {
		super.draw(g, new Color(150, 0, 150));
		körper.draw(g, new Color(150,0,150));
		for (int i = 0; i<=7; i++){
			tentakel[i].draw(g, new Color(150, 0, 150)); 
		}
		linkesAuge.draw(g, new Color(255, 255, 255));
		rechtesAuge.draw(g, new Color(255, 255, 255));
	}

	public void move() {
		// Point mousePosition = MouseInfo.getPointerInfo().getLocation();
		mittelpunkt.x = mittelpunkt.x + richtung.x;
		mittelpunkt.y = mittelpunkt.y + richtung.y;

		if(getMittelpunkt().x>500||getMittelpunkt().x<0||getMittelpunkt().y>300||getMittelpunkt().y<0){
			richtung.drehen(180);
		}
		
		i = i+1;
		if (i==randSchleife+1){
			
			randWinkel = randomGenerator.nextInt(8)-4;
			i=0;
			randSchleife = randomGenerator.nextInt(30);

		}

		richtung.drehen(randWinkel);

		
		for (int j = 0; j<=7; j++){
			tentakel[j].update(körper.getMittelpunkt());
		}
		linkesAuge.update(this.mittelpunkt, richtung);
		rechtesAuge.update(this.mittelpunkt, richtung);
		körper.update(mittelpunkt, radius);
	}
}
