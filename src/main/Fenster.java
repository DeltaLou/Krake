package main;

import java.awt.*;
import java.awt.event.*;

public class Fenster extends Frame {
	Krake polly;

	public Fenster() { // Konstruktor
		this.setVisible(true);
		this.setSize(600, 400); // Fenstergr��e einstellen
		setTitle("Krake"); // Fenstertitel setzen

		// EventListener f�r das Fenster hinzuf�gen
		// (notwendig, damit das Fenster geschlossen werden kann)
		addWindowListener(new TestWindowListener());
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

		polly = new Krake(new Vektor(200, 200), 70);
		while (true) {
			update();
			repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void update() {
		polly.move();
	}

	// class variables
	private int bufferWidth;
	private int bufferHeight;
	private Image bufferImage;
	private Graphics bufferGraphics;

	@Override
	public void paint(Graphics g) {
		// checks the buffersize with the current panelsize
		// or initialises the image with the first paint
		if (bufferWidth != getSize().width || bufferHeight != getSize().height
				|| bufferImage == null || bufferGraphics == null)
			resetBuffer();
		if (bufferGraphics != null) {
			// leert das offscreen image damit ein neues gezeichnet werden kann
			bufferGraphics.clearRect(0, 0, bufferWidth, bufferHeight);

			// calls the krake with
			// the offscreen graphics as a param
			// Krake wird alo an ein anderes Bild gezeichnet
			polly.draw(bufferGraphics);

			// we finaly paint the offscreen image onto the onscreen image
			g.drawImage(bufferImage, 0, 0, this);
		}
	}

	private void resetBuffer() {
		// always keep track of the image size
		bufferWidth = getSize().width;
		bufferHeight = getSize().height;

		// clean up the previous image
		if (bufferGraphics != null) {
			bufferGraphics.dispose();
			bufferGraphics = null;
		}
		if (bufferImage != null) {
			bufferImage.flush();
			bufferImage = null;
		}
		System.gc();

		// create the new image with the size of the panel
		bufferImage = createImage(bufferWidth, bufferHeight);
		bufferGraphics = bufferImage.getGraphics();
	}
}
