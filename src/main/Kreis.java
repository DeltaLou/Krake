package main;

import java.awt.Color;
import java.awt.Graphics;

public class Kreis {
	Vektor position;
	int durchmesser;

	
	public Kreis(Vektor pos, int d) {
		position = pos;
		durchmesser = d;
	}

	public Kreis(int d) {
		this();
		durchmesser = d;
	}

	public Kreis() {
		durchmesser = 10;
		position = new Vektor(0, 0);
	}

	public void draw(Graphics g, Color c, Vektor p) {
		g.setColor(c);
		g.fillOval((int) (position.x), (int) (position.y), durchmesser,
				durchmesser);
	}
/*	public int getRadius(int durchmesser){
		return durchmesser/2;
	}
	public void setMittelpunkt (Vektor mittelpunkt){
		this.mittelpunkt= mittelpunkt;
		
	}
	public Vektor getMittelpunkt (Vektor position, int durchmesser){
		return 
	}*/
}
