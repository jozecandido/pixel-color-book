package pcb.util;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class ImageDisplay extends Component {

	private static final long serialVersionUID = -4477490819179632104L;

	private BufferedImage img;

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}

	public ImageDisplay(BufferedImage bufferedImage) {
		img = bufferedImage;
	}

	public Dimension getPreferredSize() {
		if (img == null) {
			return new Dimension(100,100);
		} else {
			return new Dimension(img.getWidth(null), img.getHeight(null));
		}
	}

	public void display() {
		JFrame f = new JFrame("Display");

		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		f.add(this);
		f.pack();
		f.setVisible(true);
	}
	
	public static void displayImage(BufferedImage bufferedImage) {
		ImageDisplay display = new ImageDisplay(bufferedImage);
		display.display();
	}
}
