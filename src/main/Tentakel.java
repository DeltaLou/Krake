package main;

import java.awt.Color;
import java.awt.Graphics;

public class Tentakel{
Vektor abstand = new Vektor();
Vektor position = new Vektor();
int nummer;

	public Tentakel(int num, int krakenRadius){
		this.nummer = num;
		abstand.x = 0;
		abstand.y = -krakenRadius;
		abstand.drehen(60+30*nummer);
	}
	
	public void update(Vektor krakenPosition){
		position.x = krakenPosition.x + abstand.x;
		position.y = krakenPosition.y + abstand.y;
		System.out.println("Nummer: " + nummer + "; Position:"+ position.x + "," + position.y);
	}
	Kreis arm = new Kreis(position, 30);
	public void draw (Graphics g, Color c){
		arm.draw(g, c, position);
	}
}
