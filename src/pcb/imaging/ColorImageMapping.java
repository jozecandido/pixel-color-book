package pcb.imaging;

import java.awt.image.BufferedImage;

public class ColorImageMapping {

	private BufferedImage resizedImage;
	private BufferedImage userImage;

	public ColorImageMapping(BufferedImage resizedImage, BufferedImage userImage) {
		this.resizedImage = resizedImage;
		this.setUserImage(userImage);
	}
	
	public BufferedImage getResizedImage() {
		return resizedImage;
	}

	public void setResizedImage(BufferedImage resizedImage) {
		this.resizedImage = resizedImage;
	}

	public BufferedImage getUserImage() {
		return userImage;
	}

	public void setUserImage(BufferedImage userImage) {
		this.userImage = userImage;
	}
}
