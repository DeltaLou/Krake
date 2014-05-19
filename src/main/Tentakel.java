package main;

import java.awt.Color;
import java.awt.Graphics;

public class Tentakel{
Vektor abstand = new Vektor();
Vektor pos = new Vektor();
int nummer;
int armZahl;

	public Tentakel(int num, int krakenRadius){
		this.nummer = num;
		abstand.x = 0;
		abstand.y = -krakenRadius;
		abstand.drehen(108+20*nummer);
		armZahl = 10;
		for (int i = 0; i<armZahl; i++){
			armKreis[i] = new Kreis(pos, krakenRadius/20); 
		}
	}
	
	public void update(Vektor krakenPosition){
		Vektor kPosition = krakenPosition;
		pos.x = kPosition.x + abstand.x;
		pos.y = kPosition.y + abstand.y;
		//System.out.println("Nummer: " + nummer + "; Position:"+ position.x + "," + position.y);
	}
	//Kreis arm = new Kreis(pos, 30);
	Kreis[] armKreis = new Kreis[10];
	float tentakelBreite = 30;
	public void draw (Graphics g, Color c){
		for (int i = 0; i<armZahl; i++){
			armKreis[i].draw(g, c, pos); 
		}

		//arm.draw(g, c, position);
	}
}
