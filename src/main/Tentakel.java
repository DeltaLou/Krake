package main;

import java.awt.Color;
import java.awt.Graphics;

public class Tentakel{
Vektor abstand = new Vektor();
Vektor position = new Vektor();
int nummer;
Kreis arm = new Kreis();

	public Tentakel(int num, int krakenRadius){
		this.nummer = num;
		abstand.x = 0;
		abstand.y = -krakenRadius;
	}
	public void update(Vektor krakenPosition){
		abstand.drehen(60+30*nummer);
		position.x = krakenPosition.x + abstand.x;
		position.y = krakenPosition.y + abstand.y;
	}
	public void draw (Graphics g, Color c){
		arm.draw(g, c, position);
	}
}
