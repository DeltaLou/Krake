package main;

import java.awt.*;
import java.awt.event.*;

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

			// we finaly paint the offscreen image onto the onscreen image
			paintBuffer(bufferGraphics);
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

	public void paintBuffer(Graphics g) {

	}
}
