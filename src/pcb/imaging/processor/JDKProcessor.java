package pcb.imaging.processor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import pcb.imaging.ColorImageMapping;
import pcb.model.PaintSize;

class JDKProcessor extends AbstractImageProcessor {

	BufferedImage buffImage = null;
	
	@Override
	void preProcess() {
		try {
			buffImage = ImageIO.read(imageFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	String resize() {
		int originalWidth = buffImage.getWidth();
		int originalHeight = buffImage.getHeight();
		
		double paintSizeRatio = (double) paintSize.getHeight() / paintSize.getWidth();
		double originalRatio = 0;
		
		int newWidth = 0;
		int newHeight = 0;
		
		// Portrait
		if (originalHeight >= originalWidth) {
			originalRatio = (double) originalHeight / originalWidth;
			if (paintSizeRatio >= originalRatio) {
				newWidth = paintSize.getWidth();
				newHeight = (int) Math.round((double) originalHeight / ((double) originalWidth / paintSize.getWidth()));
			} else {
				newHeight = paintSize.getHeight();
				newWidth = (int) Math.round((double) originalWidth / ((double) originalHeight / paintSize.getHeight()));
			}
		} else {	// Landscape
			originalRatio = (double) originalWidth / originalHeight;
			if (paintSizeRatio >= originalRatio) {
				newHeight = paintSize.getWidth();
				newWidth = (int) Math.round((double) originalWidth / ((double) originalHeight / paintSize.getWidth()));
			} else {
				newWidth = paintSize.getHeight();
				newHeight = (int) Math.round((double) originalHeight / ((double) originalWidth / paintSize.getHeight()));
			}
		}
		
		int type = buffImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : buffImage.getType();
		BufferedImage resizedImage = resizeImage(buffImage, type, newWidth, newHeight);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(resizedImage, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] bytes = baos.toByteArray();
		
		return Base64.getEncoder().encodeToString(bytes);
	}
	
	private BufferedImage resizeImage(BufferedImage originalImage, int type, int width, int height){
		
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
			
		return resizedImage;
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
	ColorImageMapping createColorMapping() {
		return new ColorImageMapping(resizedImage, userImage);
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
