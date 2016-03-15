package pcb.core.imaging;

public class Drawing {
	private ColorImageMapping imageMapping;
	private MappedImage mappedImage;
	
	public Drawing(ColorImageMapping imageMapping, MappedImage mappedImage) {
		this.setImageMapping(imageMapping);
		this.setMappedImage(mappedImage);
	}
	
	public ColorImageMapping getImageMapping() {
		return imageMapping;
	}

	public void setImageMapping(ColorImageMapping imageMapping) {
		this.imageMapping = imageMapping;
	}

	public MappedImage getMappedImage() {
		return mappedImage;
	}

	public void setMappedImage(MappedImage mappedImage) {
		this.mappedImage = mappedImage;
	}
}
