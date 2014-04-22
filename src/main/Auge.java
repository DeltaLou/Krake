package main;
public class Auge extends Kreis
{    
    //Vektor Abstand = new Vektor (1, 1); 
    Vektor abstand;
    public Auge(Vektor a, int r, Vektor b)
    {    
    	super (a, r);
    	abstand = b;
    }
    
    public void update(Vektor krakenPosition)
    {
   	  position.x = krakenPosition.x + abstand.x;
   	  position.y = krakenPosition.y + abstand.y;
    }
    
}