package pcb.imaging.processor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import pcb.imaging.ColorImageMapping;
import pcb.model.ColorPencilBox;
import pcb.model.PaintSize;

public abstract class AbstractImageProcessor implements ImageProcessor{
		
	File imageFile;
	ColorPencilBox pencilBox;
	PaintSize paintSize;
	
	@Override
	public ColorImageMapping processImage(File imageFile, ColorPencilBox pencilBox, PaintSize paintSize) {
		this.imageFile = imageFile;
		this.pencilBox = pencilBox;
		this.paintSize = paintSize;
		preProcess();
		adjustContrastAndSaturation();
		resize();
		genaretePreview();
		return createColorMapping();
	}
	
	abstract void preProcess();

	abstract String resize();

	abstract void adjustContrastAndSaturation();
	
	abstract void generatePreview();
	
	abstract ColorImageMapping createColorMapping();
}
