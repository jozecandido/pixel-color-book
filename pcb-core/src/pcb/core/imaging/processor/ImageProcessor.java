package pcb.core.imaging.processor;

import java.io.IOException;

import pcb.core.imaging.ColorImageMapping;
import pcb.core.model.ImageSize;

public interface ImageProcessor {
	public ColorImageMapping processImage(byte[] image, ImageSize paintSize) throws IOException;
	
	public static ImageProcessor getCurrentProcessor() {
		return System.getProperty("java.version") != "0" ? new JDKProcessor() : new AndroidProcessor();
	} 
}
