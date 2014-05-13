package main;

import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;

public class Fenster extends Frame {
	Krakenpanel panel;

	public Fenster() { // Konstruktor
		this.setVisible(true);
		this.setSize(600, 400); // Fenstergr��e einstellen
		setTitle("Krake"); // Fenstertitel setzen

		// EventListener f�r das Fenster hinzuf�gen
		// (notwendig, damit das Fenster geschlossen werden kann)
		addWindowListener(new TestWindowListener());
		panel = new Krakenpanel();
		add(panel);
	}

	class TestWindowListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().dispose(); // Fenster "killen"
			System.exit(0); // VM "killen"
		}
	}

	public static void main(String[] args) {
		// System.setProperty("sun.awt.noerasebackground", "true");
		Fenster fenster = new Fenster();
		fenster.start();
	}

	public void start() {
		while (true) {
			panel.move();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/*
	 * public void update(){ //buffer.update(g); } public void paint(Graphics
	 * g){ panel.paint(g); }
	 */
}
