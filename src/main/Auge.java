package main;

import java.awt.Color;
import java.awt.Graphics;


public class Auge extends Kreis
{	
	Vektor abstand;
	Pupille pupille;
	public Auge(Vektor a, int r, Vektor b)
	{    
	    super (b, r);
	    abstand = a;
	    pupille = new Pupille (position, r-10, abstand);
	}
	
	public void update(Vektor krakenPosition, Vektor richtung)
	{
		 position.x = krakenPosition.x + abstand.x;
		 position.y = krakenPosition.y + abstand.y;
		 pupille.update(this.position, richtung);
	}
	
	public void draw(Graphics g, Color c, Vektor p) {
		super.draw(g, c, p);
		pupille.draw(g, new Color (0, 0, 0), position);
	}
}