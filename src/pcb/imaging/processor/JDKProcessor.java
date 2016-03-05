package pcb.imaging.processor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import pcb.imaging.ColorImageMapping;
import pcb.model.ImageSize;
import pcb.util.Common;

class JDKProcessor extends AbstractImageProcessor {

	BufferedImage buffImage = null;
	BufferedImage resizedImage = null;
	
	@Override
	void preProcess() throws IOException {
		buffImage = ImageIO.read(new ByteArrayInputStream(imageFile));
	}

	@Override
	void resize() {
		
		ImageSize newSize = Common.calculateNewSize(new ImageSize(buffImage.getWidth(), buffImage.getHeight()), paintSize);
		
		int type = buffImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : buffImage.getType();		
				
		resizedImage = new BufferedImage(newSize.getWidth(), newSize.getHeight(), type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(buffImage, 0, 0, newSize.getWidth(), newSize.getHeight(), null);
		g.dispose();
	}

	@Override
	void adjustContrastAndSaturation() {
		//http://docs.oracle.com/javafx/2/api/javafx/scene/effect/ColorAdjust.html
		/*
		ColorAdjust colorAdjust = new ColorAdjust();
		colorAdjust.setContrast(0.1);
		colorAdjust.setSaturation(0.2);
		*/
	}

	@Override
	ColorImageMapping createColorMapping() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(resizedImage, "png", baos);
		byte[] bytes = baos.toByteArray();
		
		ColorImageMapping mapping = new ColorImageMapping(imageFile, paintSize, box);
		mapping.setResizedImage(bytes);
		
		return mapping;
	}

	@SuppressWarnings("unused")
	private double distanceTo(Color pixelColor, Color pencilColor) {
		double redDistance = pixelColor.getRed() - pencilColor.getRed();
		double greenDistance = pixelColor.getGreen() - pencilColor.getGreen();
		double blueDistance = pixelColor.getBlue() - pencilColor.getBlue();

		double distanceTo = (redDistance * redDistance) 
				+ (greenDistance * greenDistance)
				+ (blueDistance * blueDistance);
		distanceTo = Math.sqrt(distanceTo);

		return distanceTo;
	}

}
