package main;

import java.awt.Color;
import java.awt.Graphics;

public class Tentakel{
Vektor abstand = new Vektor();
Vektor pos = new Vektor();
int nummer;
int armLängenZahl = 30;
	public Tentakel(int num, int krakenRadius){
		this.nummer = num;
		abstand.x = 0;
		abstand.y = -krakenRadius;
		abstand.drehen(108+20*nummer);
		for (int i = 0; i<armLängenZahl; i++){
			armKreis[i] = new Kreis(new Vektor(), krakenRadius/20); 
		}
	}
	Kreis[] armKreis = new Kreis[armLängenZahl];
	Vektor position = new Vektor();
	public void update(Vektor krakenPosition){
		pos.x = krakenPosition.x + abstand.x;
		pos.y = krakenPosition.y + abstand.y;
		for (int i = 0; i<armLängenZahl; i++){
			armKreis[i].mittelpunkt.x= pos.x + abstand.x*i/10;
			armKreis[i].mittelpunkt.y= pos.y+abstand.y*i/10;
			//armKreis[i].mittelpunkt.x= krakenPosition.x + abstand.x + abstand.x*i/5;
			//armKreis[i].mittelpunkt.y= krakenPosition.y + abstand.y + abstand.y*i/5;
		}
		//System.out.println("Nummer: " + nummer + "; Position:"+ pos.x + "," + pos.y);
	}

	float tentakelBreite = 30;

	public void draw (Graphics g, Color c){

		for (int i = 0; i<armLängenZahl; i++){
		//	pos.x = position.x + abstand.x*i/20;
		//	pos.y = position.y + abstand.y*i/20;
			armKreis[i].draw(g, c); 
		}

	}
}
