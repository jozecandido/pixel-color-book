package pcb.model;

/**
 * The paint mode determines the size of the drawing. 
 *
 */
public enum PaintMode {
	
	EASY(21, 31),
	MEDIUM(36, 53),
	ADVANCED(50, 72);

	private int height;
	private int width;
	
	private PaintMode(int width, int height) {
		this.setHeight(height);
		this.setWidth(width);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
