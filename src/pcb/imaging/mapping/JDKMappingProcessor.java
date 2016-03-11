package pcb.imaging.mapping;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import pcb.exception.PcbException;
import pcb.imaging.ColorImageMapping;
import pcb.model.ColorPencilBox;
import pcb.model.ImageSize;
import pcb.model.MappedImage;
import pcb.model.Pencil;
import pcb.util.Common;

public class JDKMappingProcessor implements MappingProcessor {

	@Override
	public MappedImage processMapping(ColorImageMapping map, ColorPencilBox box) throws PcbException{
		try{
			return mapImage(map.getResizedImage(), map.getSize(), box);
		} catch (Exception e) {
			throw new PcbException();
		}
	}
	
	public MappedImage mapImage(byte[] image, ImageSize size, ColorPencilBox box) throws IOException {
		
		BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(image));
		
		BufferedImage pencilImage = Common.deepCopy(bufferedImage);
		
		for (int y = 0; y < bufferedImage.getHeight(); y++) {
		    for (int x = 0; x < bufferedImage.getWidth(); x++) {
		          int  clr   = bufferedImage.getRGB(x, y); 
		          Pencil pencil = box.getPencil(clr);
		          pencilImage.setRGB(x, y, pencil.getColor().getRGB());
		    }
		}
		MappedImage mappedImage = new MappedImage();
		mappedImage.setPencilImage(Common.toByteArray(pencilImage));
		
		return mappedImage;

	}
}
