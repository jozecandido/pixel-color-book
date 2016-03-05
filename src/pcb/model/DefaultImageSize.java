package pcb.model;

public enum DefaultImageSize {
	SMALL(new ImageSize(21, 31)),
	MEDIUM(new ImageSize(36, 53)),
	LARGE(new ImageSize(50, 72)),
	USER(new ImageSize(680, 680));
	
	private ImageSize size;
	
	private DefaultImageSize(ImageSize size) {
		this.size = size;
	}

	public ImageSize getSize() {
		return size;
	}
}