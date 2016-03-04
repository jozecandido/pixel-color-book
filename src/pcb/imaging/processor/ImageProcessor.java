package pcb.imaging.processor;

import java.io.File;

import pcb.imaging.ColorImageMapping;

public interface ImageProcessor {
	public ColorImageMapping processImage(File image, int height, int width);
}
