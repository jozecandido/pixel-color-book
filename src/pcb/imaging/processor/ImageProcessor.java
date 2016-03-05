package pcb.imaging.processor;

import java.io.IOException;

import pcb.imaging.ColorImageMapping;
import pcb.model.ColorPencilBox;
import pcb.model.PaintSize;

public interface ImageProcessor {
	public ColorImageMapping processImage(byte[] image, ColorPencilBox pencilBox, PaintSize paintSize) throws IOException;
}
