package pcb.imaging.processor;

import java.io.IOException;

import pcb.imaging.ColorImageMapping;
import pcb.model.ImageSize;

public interface ImageProcessor {
	public ColorImageMapping processImage(byte[] image, ImageSize paintSize) throws IOException;
	
	public static ImageProcessor getCurrentProcessor() {
		return System.getProperty("java.version") != "0" ? new JDKProcessor() : new AndroidProcessor();
	} 
}
