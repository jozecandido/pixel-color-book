package pcb.imaging.processor;

import java.io.IOException;

import pcb.imaging.ColorImageMapping;
import pcb.model.ColorPencilBox;
import pcb.model.ImageSize;

public interface ImageProcessor {
	public ColorImageMapping processImage(byte[] image, ColorPencilBox pencilBox, ImageSize paintSize) throws IOException;
}
