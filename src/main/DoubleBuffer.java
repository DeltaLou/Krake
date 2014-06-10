package main;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class DoubleBuffer extends Panel {

	public DoubleBuffer() {
		super();
	}

	public void update(Graphics g) {
		paint(g);
	}

	// class variables
	private int bufferWidth;
	private int bufferHeight;
	private BufferedImage bufferImage;
	private Graphics2D bufferGraphics;

	@Override
	public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        Color color1 = Color.WHITE;
        Color color2 = Color.BLUE;
        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
        g2d.setPaint(gp);
		// checks the buffersize with the current panelsize
		// or initialises the image with the first paint
		if (bufferWidth != getSize().width || bufferHeight != getSize().height
				|| bufferImage == null || bufferGraphics == null)
			resetBuffer();
		if (bufferGraphics != null) {
			// leert das offscreen image damit ein neues gezeichnet werden kann
			bufferGraphics.clearRect(0, 0, bufferWidth, bufferHeight);

			// we finaly paint the offscreen image onto the onscreen image
			paintBuffer(bufferGraphics);
	        g2d.fillRect(0, 0, w, h);
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

		bufferImage = new BufferedImage(bufferWidth, bufferHeight,
				BufferedImage.TYPE_INT_RGB);
		bufferGraphics = bufferImage.createGraphics();
		bufferGraphics.setRenderingHint (RenderingHints.KEY_ANTIALIASING,   RenderingHints.VALUE_ANTIALIAS_ON);
	}

	public void paintBuffer(Graphics g) {

	}
}
