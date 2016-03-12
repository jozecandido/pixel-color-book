package pcb.imaging;

import pcb.model.ColorPencilBox;

public class MappedImage {
	private byte[] pencilImage;
	private int[][] pencilNumberMapping;
	private String[][] colorMapping;
	private ColorPencilBox box;

	
	public int[][] getPencilNumberMapping() {
		return pencilNumberMapping;
	}

	public void setPencilNumberMapping(int[][] mapping) {
		this.pencilNumberMapping = mapping;
	}
	
	public byte[] getPencilImage() {
		return pencilImage;
	}

	public void setPencilImage(byte[] pencilImage) {
		this.pencilImage = pencilImage;
	}

	public String[][] getColorMapping() {
		return colorMapping;
	}

	public void setColorMapping(String[][] colorMapping) {
		this.colorMapping = colorMapping;
	}

	public ColorPencilBox getBox() {
		return box;
	}

	public void setBox(ColorPencilBox box) {
		this.box = box;
	}
}
