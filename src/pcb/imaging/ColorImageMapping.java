package pcb.imaging;

import pcb.model.ImageSize;

public class ColorImageMapping {

	byte[] originalImage;
	byte[] resizedImage;	
	ImageSize size;

	public byte[] getOriginalImage() {
		return originalImage;
	}

	public void setOriginalImage(byte[] originalImage) {
		this.originalImage = originalImage;
	}

	public byte[] getResizedImage() {
		return resizedImage;
	}

	public void setResizedImage(byte[] resizedImage) {
		this.resizedImage = resizedImage;
	}

	public ImageSize getSize() {
		return size;
	}

	public void setSize(ImageSize size) {
		this.size = size;
	}
}
