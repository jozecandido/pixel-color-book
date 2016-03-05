package pcb.util;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import pcb.model.ImageSize;

public final class Common {

	private static final int BUFFER_SIZE = 8192;

	public static byte[] encodeFile(File image) throws IOException {
		
		InputStream inputStream = null;
		byte[] byteArray;

		try {
			inputStream = new FileInputStream(image);
			byte[] buffer = new byte[BUFFER_SIZE];
			int bytesRead;
			ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		    while ((bytesRead = inputStream.read(buffer)) != -1) {
		    	output.write(buffer, 0, bytesRead);
		    }
		    
			byteArray = output.toByteArray();
		} finally {
			if(inputStream != null)
				inputStream.close();
		}		
		return byteArray;
	}
	
	public static ImageSize calculateNewSize(ImageSize originalSize, ImageSize newSize) {
		double newSizeRatio = (double) newSize.getHeight() / newSize.getWidth();
		double originalRatio = 0;
		
		int originalHeight = originalSize.getHeight();
		int originalWidth = originalSize.getWidth();
		int newWidth = 0;
		int newHeight = 0;
		
		// Portrait
		if (originalHeight >= originalWidth) {
			originalRatio = (double) originalHeight / originalWidth;
			if (newSizeRatio >= originalRatio) {
				newWidth = newSize.getWidth();
				newHeight = (int) Math.round((double) originalHeight / ((double) originalWidth / newSize.getWidth()));
			} else {
				newHeight = newSize.getHeight();
				newWidth = (int) Math.round((double) originalWidth / ((double) originalHeight / newSize.getHeight()));
			}
		} else {	// Landscape
			originalRatio = (double) originalWidth / originalHeight;
			if (newSizeRatio >= originalRatio) {
				newHeight = newSize.getWidth();
				newWidth = (int) Math.round((double) originalWidth / ((double) originalHeight / newSize.getWidth()));
			} else {
				newWidth = newSize.getHeight();
				newHeight = (int) Math.round((double) originalHeight / ((double) originalWidth / newSize.getHeight()));
			}
		}
		
		return new ImageSize(newWidth, newHeight);
	}
	
	public static BufferedImage deepCopy(BufferedImage bi) {
		 ColorModel cm = bi.getColorModel();
		 boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
		 WritableRaster raster = bi.copyData(null);
		 return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
	}
	
	public static byte[] toByteArray(BufferedImage buffImage) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(buffImage, "png", baos);
		return baos.toByteArray();
	}
}
