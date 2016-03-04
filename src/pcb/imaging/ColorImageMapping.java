package pcb.imaging;

import java.awt.image.BufferedImage;

public class ColorImageMapping {

	private BufferedImage resizedImage;

	public ColorImageMapping(BufferedImage resizedImage) {
		this.resizedImage = resizedImage;
	}
	
	public BufferedImage getResizedImage() {
		return resizedImage;
	}

	public void setResizedImage(BufferedImage resizedImage) {
		this.resizedImage = resizedImage;
	}
}
