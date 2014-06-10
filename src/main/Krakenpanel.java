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
		Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        Color color1 = Color.WHITE;
        Color color2 = Color.BLUE;
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
		polly.draw(g);

	}
}
