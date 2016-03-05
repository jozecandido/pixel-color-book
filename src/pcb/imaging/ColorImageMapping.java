package pcb.imaging;

import pcb.model.ColorPencilBox;
import pcb.model.PaintSize;

public class ColorImageMapping {

	byte[] originalImage;
	byte[] resizedImage;
	int[][] mapping;
	
	PaintSize size;
	ColorPencilBox box;
	
	public ColorImageMapping(byte[] original, PaintSize size, ColorPencilBox box) {
		this.originalImage = original;
		this.size = size;
		this.box = box;
	}

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

	public int[][] getMapping() {
		return mapping;
	}

	public void setMapping(int[][] mapping) {
		this.mapping = mapping;
	}

	public PaintSize getSize() {
		return size;
	}

	public void setSize(PaintSize size) {
		this.size = size;
	}

	public ColorPencilBox getBox() {
		return box;
	}

	public void setBox(ColorPencilBox box) {
		this.box = box;
	}
	
	
}
