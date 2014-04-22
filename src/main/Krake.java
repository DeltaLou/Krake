package main;
import java.awt.Color;
import java.awt.Graphics;
//import java.awt.MouseInfo;
//import java.awt.Point;

public class Krake extends Kreis
{
    Vektor richtung = new Vektor (1,1);
    public Krake(Vektor pos, int r)
    {    
        super (pos, r);
    }
    Auge linkesAuge = new Auge (new Vektor(20, 40), 50, position);
    Auge rechtesAuge = new Auge (new Vektor(80, 40), 50, position);
    //System.out.println();
    public void draw(Graphics g)
    {
    	super.draw(g, new Color (150, 0, 150), position);
    	//System.out.println(this.position);

    	linkesAuge.draw(g, new Color (255, 255, 255), position);
    	rechtesAuge.draw(g, new Color (255, 255, 255), position);
    }
    
	public void move ()
	{ 
		//Point mousePosition = MouseInfo.getPointerInfo().getLocation();
    	linkesAuge.update(this.position, richtung);
    	rechtesAuge.update(this.position, richtung);	
		position.x = position.x + richtung.x;
		position.y = position.y + richtung.y;
        richtung = richtung.drehen(3);
	}
}

