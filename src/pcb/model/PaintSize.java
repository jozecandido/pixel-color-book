package pcb.model;

public enum PaintSize {
	
	SMALL(21, 31),
	MEDIUM(36, 53),
	LARGE(50, 72),
	USER(800, 800);

	private int width;
	private int height;
	
	private PaintSize(int width, int height) {
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
