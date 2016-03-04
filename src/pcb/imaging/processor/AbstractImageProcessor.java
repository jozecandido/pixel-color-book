package pcb.imaging.processor;

import java.io.File;

import pcb.imaging.ColorImageMapping;
import pcb.model.ColorPencilBox;
import pcb.model.PaintSize;

public abstract class AbstractImageProcessor implements ImageProcessor{
		
	@Override
	public ColorImageMapping processImage(File image, ColorPencilBox pencilBox, PaintSize paintSize) {
		preProcess();
		adjustHue();
		adjustSaturation();
		resize();
		return createColorMapping();
	}
	
	abstract void preProcess();

	abstract void resize();

	abstract void adjustHue();

	abstract void adjustSaturation();
	
	abstract ColorImageMapping createColorMapping();
}
