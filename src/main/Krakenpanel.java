package main;

import java.awt.*;

public class Krakenpanel extends DoubleBuffer {
	public Krakenpanel() {
		super();
	}

	Krake polly = new Krake(new Vektor(200, 200), 70);

	public void move() {
		polly.move();
		repaint();
	}

	public void paintBuffer(Graphics g) {
		polly.draw(g);
	}
}
