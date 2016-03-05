package pcb.imaging.processor;

import java.io.IOException;

import pcb.imaging.ColorImageMapping;
import pcb.model.ColorPencilBox;
import pcb.model.PaintSize;

abstract class AbstractImageProcessor implements ImageProcessor{
		
	byte[] imageFile;
	ColorPencilBox box;
	PaintSize paintSize;
	
	@Override
	public ColorImageMapping processImage(byte[] image, ColorPencilBox pencilBox, PaintSize paintSize) throws IOException {
		this.imageFile = image;
		this.paintSize = paintSize;
		this.box = pencilBox;
		
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
