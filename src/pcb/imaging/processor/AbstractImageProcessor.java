package pcb.imaging.processor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import pcb.imaging.ColorImageMapping;
import pcb.model.ColorPencilBox;
import pcb.model.PaintSize;

public abstract class AbstractImageProcessor implements ImageProcessor{
		
	@Override
	public ColorImageMapping processImage(File imageFile, ColorPencilBox pencilBox, PaintSize paintSize) {
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(imageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		preProcess();
		adjustContrastAndSaturation();
		BufferedImage resizedImage = resize(image, paintSize);
		BufferedImage userImage = resize(resizedImage, PaintSize.USER);
		
		return createColorMapping(resizedImage, userImage);
	}
	
	abstract void preProcess();

	abstract BufferedImage resize(BufferedImage image, PaintSize paintSize);

	abstract void adjustContrastAndSaturation();
	
	abstract ColorImageMapping createColorMapping(BufferedImage resizedImage, BufferedImage userImage);
}
