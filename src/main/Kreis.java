package main;

import java.awt.Color;
import java.awt.Graphics;

public class Kreis {
	Vektor mittelpunkt;
	int radius;

	
	public Kreis(Vektor m, int r) {
		mittelpunkt = m;
		radius = r;
	}

	public Kreis(int r) {
		this();
		radius = r;
	}

	public Kreis() {
		radius = 10;
		mittelpunkt = new Vektor(radius, radius);
	}

	public void draw(Graphics g, Color c, Vektor p) {
		g.setColor(c);
		int durchmesser = 2*radius;
		Vektor position = new Vektor();
		position.x = mittelpunkt.x-radius;
		position.y = mittelpunkt.y -radius;
		g.fillOval((int) (position.x), (int) (position.y), durchmesser,
				durchmesser);
	}
	public int getRadius(){
		return radius;
	}
	public void setRadius(int radius){
		this.radius = radius;
	}
	public Vektor getMittelpunkt (){
		return mittelpunkt;
	}
	public void setMittelpunkt (Vektor mittelpunkt){
		this.mittelpunkt = mittelpunkt;

		
	}
}
