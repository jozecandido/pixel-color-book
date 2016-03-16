package pcb.core.imaging.processor;

import java.io.IOException;

import pcb.core.imaging.ColorImageMapping;
import pcb.core.model.ImageSize;

abstract class AbstractImageProcessor implements ImageProcessor{
		
	byte[] imageFile;
	ImageSize paintSize;
	
	@Override
	public ColorImageMapping processImage(byte[] image, ImageSize paintSize) throws IOException {
		this.imageFile = image;
		this.paintSize = paintSize;
		
		preProcess();
		adjustContrastAndSaturation();
		resize();
		return createColorMapping();
	}
	
	abstract void preProcess() throws IOException;

	abstract void resize();

	abstract void adjustContrastAndSaturation();
		
	abstract ColorImageMapping createColorMapping() throws IOException;
}
