package main;
import java.awt.*;
import java.awt.event.*;
public class Fenster extends Frame 
	{
    Krake polly;
    
    public Fenster () 
 		{											//Konstruktor
        this.setVisible(true);
        this.setSize(600, 400);
        setTitle("Krake");  						// Fenstertitel setzen
        											// Fenstergröße einstellen  
        addWindowListener(new TestWindowListener()); // EventListener für das Fenster hinzufügen
                                                     // (notwendig, damit das Fenster geschlossen werden kann)
 		}
    class TestWindowListener extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            e.getWindow().dispose();                   // Fenster "killen"
            System.exit(0);                            // VM "killen"
        }           
    }

    
    public static void main(String[] args) {
        
        Fenster fenster = new Fenster();        
        fenster.start();
    }
    
    public void start() {
    	
    	polly = new Krake(new Vektor(200, 200), 150);
        while(true) {            
            update();
            repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void paint(Graphics g) {
        polly.draw(g);
    }
    
    public void update() {
        polly.move();
    }

}