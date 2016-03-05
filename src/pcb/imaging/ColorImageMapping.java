package pcb.imaging;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import pcb.model.ColorPencilBox;
import pcb.model.ImageSize;
import pcb.model.Pencil;
import pcb.util.Common;

public class ColorImageMapping {

	byte[] originalImage;
	byte[] resizedImage;
	byte[] pencilImage;
	int[][] mapping;
	
	ImageSize size;
	ColorPencilBox box;
	
	public ColorImageMapping(BufferedImage bufferedImage, ImageSize size, ColorPencilBox box) throws IOException {
		this.originalImage = Common.toByteArray(bufferedImage);
		this.size = size;
		this.box = box;
		
		BufferedImage pencilImage = Common.deepCopy(bufferedImage);
		
		for (int y = 0; y < bufferedImage.getHeight(); y++) {
		    for (int x = 0; x < bufferedImage.getWidth(); x++) {
		          int  clr   = bufferedImage.getRGB(x, y); 
		          Pencil pencil = getPencil(clr, box);
		          pencilImage.setRGB(x, y, pencil.getColor().getRGB());
		    }
		}
		
		this.resizedImage = Common.toByteArray(bufferedImage);
		this.pencilImage = Common.toByteArray(pencilImage);
	}
	
	private Pencil getPencil(int clr, ColorPencilBox box) {
        Color pixelColor = new Color(clr);
        
        double smallestDistance = 99999; 
        Pencil bestPencil = null;
        List<Pencil> pencils = box.getPencils();
        for (Pencil pencil : pencils) {
			double distance = distanceTo(pixelColor, pencil.getColor());
			if (distance < smallestDistance) {
				smallestDistance = distance;
				bestPencil = pencil;
			}
		}
        
		return bestPencil;
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

	public byte[] getOriginalImage() {
		return originalImage;
	}

	public void setOriginalImage(byte[] originalImage) {
		this.originalImage = originalImage;
	}

	public byte[] getResizedImage() {
		return resizedImage;
	}

	public void setResizedImage(byte[] resizedImage) {
		this.resizedImage = resizedImage;
	}

	public int[][] getMapping() {
		return mapping;
	}

	public void setMapping(int[][] mapping) {
		this.mapping = mapping;
	}

	public ImageSize getSize() {
		return size;
	}

	public void setSize(ImageSize size) {
		this.size = size;
	}

	public ColorPencilBox getBox() {
		return box;
	}

	public void setBox(ColorPencilBox box) {
		this.box = box;
	}

	public byte[] getPencilImage() {
		return pencilImage;
	}

	public void setPencilImage(byte[] pencilImage) {
		this.pencilImage = pencilImage;
	}
	
	
}
