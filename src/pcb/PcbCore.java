package pcb;

import java.io.File;
import java.io.IOException;

import pcb.exception.BoxSizeException;
import pcb.exception.NoPencilBrandException;
import pcb.exception.PcbException;
import pcb.imaging.ColorImageMapping;
import pcb.imaging.Drawing;
import pcb.imaging.MappedImage;
import pcb.imaging.mapping.MappingProcessor;
import pcb.imaging.processor.ImageProcessor;
import pcb.model.ColorPencilBox;
import pcb.model.DefaultImageSize;
import pcb.model.PencilBrand;
import pcb.model.factory.ColorPencilBoxFactory;
import pcb.output.HtmlOutput;
import pcb.util.Common;
import pcb.util.ImageDisplay;

public class PcbCore {
	
	public Drawing createDrawing(File image, DefaultImageSize paintSize, int boxSize, PencilBrand brand) {

		try {
			return createDrawing(Common.encodeFile(image), paintSize, boxSize, brand);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Drawing createDrawing(byte[] image, DefaultImageSize paintSize, int boxSize, PencilBrand brand) {

		try {
			
			ColorPencilBox box = ColorPencilBoxFactory.createBox(boxSize, brand);

			ImageProcessor processor = ImageProcessor.getCurrentProcessor();
			ColorImageMapping mapping = processor.processImage(image, paintSize.getSize());			
			
			MappingProcessor mapper = MappingProcessor.getCurrentProcessor();
			MappedImage mapped = mapper.processMapping(mapping, box);			
			
			return new Drawing(mapping, mapped);
			
		} catch (NoPencilBrandException e) {
			e.printStackTrace();
		} catch (BoxSizeException e) {
			e.printStackTrace();
		} catch (PcbException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) {
		PcbCore pcb = new PcbCore();
		
		
		try {
			
			Drawing d1 = pcb.createDrawing(
					new File("res/sample1.jpg"), 
					DefaultImageSize.LARGE, 
					60, 
					PencilBrand.FaberCastell);
			
			System.out.println(new HtmlOutput().output(d1));

			Drawing d2 = pcb.createDrawing(
					d1.getImageMapping().getResizedImage(), 
					DefaultImageSize.USER, 
					60, 
					PencilBrand.FaberCastell);
			
			ImageDisplay.displayImage(d2.getImageMapping().getResizedImage());
			ImageDisplay.displayImage(d2.getMappedImage().getPencilImage());

			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
