package pcb.core.imaging;

import pcb.core.model.ColorPencilBox;

public class MappedImage {
	private byte[] pencilImage;
	private String[][] pencilNumberMapping;
	private String[][] colorMapping;
	private ColorPencilBox box;

	
	public String[][] getPencilNumberMapping() {
		return pencilNumberMapping;
	}

	public void setPencilNumberMapping(String[][] mapping) {
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
