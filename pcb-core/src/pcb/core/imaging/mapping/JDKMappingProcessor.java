package pcb.core.imaging.mapping;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import pcb.core.exception.PcbException;
import pcb.core.imaging.ColorImageMapping;
import pcb.core.imaging.MappedImage;
import pcb.core.model.ColorPencilBox;
import pcb.core.model.ImageSize;
import pcb.core.model.Pencil;
import pcb.core.util.Common;

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
		
		int height = bufferedImage.getHeight();
		int width = bufferedImage.getWidth();
		
		Pencil pencil = null;
		String[][] number = new String[height][width];
		String[][] color = new String[height][width];
		HashMap<Integer, Pencil> cachePencil = new HashMap<Integer, Pencil>();
		for (int y = 0; y < height; y++) {
		    for (int x = 0; x < width; x++) {
		          int  clr   = bufferedImage.getRGB(x, y);
		          if(cachePencil.containsKey(clr)) {
		        	  pencil = cachePencil.get(clr);
		          } else {
			          pencil = box.getPencil(clr);
			          cachePencil.put(clr, pencil);
		          }
		          number[y][x] = String.valueOf(pencil.getNumber());
		          color[y][x] = pencil.getColor().getHex();
		          pencilImage.setRGB(x, y, pencil.getColor().getRGB());
		    }
		}
		MappedImage mappedImage = new MappedImage();
		mappedImage.setPencilImage(Common.toByteArray(pencilImage));
		mappedImage.setPencilNumberMapping(number);
		mappedImage.setColorMapping(color);
		return mappedImage;

	}
}
