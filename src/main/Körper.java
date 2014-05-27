package main;

import java.awt.Color;
import java.awt.Graphics;

public class Körper extends Kreis{
	Vektor Abstand;
	public Körper(Vektor krakenMittelpunkt, int krakenRadius){
		super(new Vektor(krakenMittelpunkt.x, krakenMittelpunkt.y+krakenRadius), krakenRadius/2);

	}
	public void update(Vektor krakenMittelpunkt, int krakenRadius){
		this.mittelpunkt.x= krakenMittelpunkt.x;
		this.mittelpunkt.y = krakenMittelpunkt.y+krakenRadius/2;
	}
	public void draw(Graphics g, Color c){
		super.draw(g, c);
	}
	
}
