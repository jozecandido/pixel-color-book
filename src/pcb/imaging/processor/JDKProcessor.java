package pcb.imaging.processor;

import java.awt.Color;
import java.io.File;

import pcb.imaging.ColorImageMapping;

class JDKProcessor extends AbstractImageProcessor {

	@Override
	void preProcess() {
		// TODO Auto-generated method stub
	}

	@Override
	void resize() {
		// TODO Auto-generated method stub
	}

	@Override
	void adjustHue() {
		// TODO Auto-generated method stub
	}

	@Override
	void adjustSaturation() {
		// TODO Auto-generated method stub
	}

	@Override
	ColorImageMapping createColorMapping() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayImage(File imageFile) {
		ImageDisplay display = new ImageDisplay(imageFile);
		display.display();
	}
	
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
