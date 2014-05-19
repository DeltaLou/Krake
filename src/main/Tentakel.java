package main;

import java.awt.Color;
import java.awt.Graphics;

public class Tentakel{
Vektor abstand = new Vektor();
Vektor pos = new Vektor();
int nummer;
int armLängenZahl;

	public Tentakel(int num, int krakenRadius){
		this.nummer = num;
		abstand.x = 0;
		abstand.y = -krakenRadius;
		abstand.drehen(108+20*nummer);
		armLängenZahl = 10;
		for (int i = 0; i<armLängenZahl; i++){
			armKreis[i] = new Kreis(pos, krakenRadius/20); 
		}
	}
	
	public void update(Vektor krakenPosition){
		pos.x = krakenPosition.x + abstand.x;
		pos.y = krakenPosition.y + abstand.y;
		//System.out.println("Nummer: " + nummer + "; Position:"+ position.x + "," + position.y);
	}
	//Kreis arm = new Kreis(pos, 30);
	Kreis[] armKreis = new Kreis[10];
	float tentakelBreite = 30;
	Vektor position= new Vektor(0,0);
	public void draw (Graphics g, Color c){
		position.x = pos.x;
		position.y = pos.y;
		for (int i = 0; i<armLängenZahl; i++){
			pos.x = position.x + abstand.x*i/20;
			pos.y = position.y + abstand.y*i/20;
			armKreis[i].draw(g, c, pos); 
		}

		//arm.draw(g, c, position);
	}
}
