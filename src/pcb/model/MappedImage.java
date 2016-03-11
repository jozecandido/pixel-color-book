package pcb.model;

public class MappedImage {
	private byte[] pencilImage;
	private int[][] mapping;
	private ColorPencilBox box;

	
	public int[][] getMapping() {
		return mapping;
	}

	public void setMapping(int[][] mapping) {
		this.mapping = mapping;
	}
	
	public byte[] getPencilImage() {
		return pencilImage;
	}

	public void setPencilImage(byte[] pencilImage) {
		this.pencilImage = pencilImage;
	}

	public ColorPencilBox getBox() {
		return box;
	}

	public void setBox(ColorPencilBox box) {
		this.box = box;
	}
}
