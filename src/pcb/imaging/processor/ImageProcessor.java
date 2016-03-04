package pcb.imaging.processor;

import java.awt.image.BufferedImage;
import java.io.File;

import pcb.imaging.ColorImageMapping;
import pcb.model.ColorPencilBox;
import pcb.model.PaintSize;

public interface ImageProcessor {
	public ColorImageMapping processImage(File image, ColorPencilBox pencilBox, PaintSize paintSize);

	public void displayImage(BufferedImage bufferedImage);
}
