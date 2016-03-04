package pcb.imaging.processor;

import java.io.File;

import pcb.imaging.ColorImageMapping;

public abstract class AbstractImageProcessor implements ImageProcessor{
		
	@Override
	public ColorImageMapping processImage(File image, int height, int width) {
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
