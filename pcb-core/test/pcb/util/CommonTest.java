package pcb.util;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import pcb.model.DefaultImageSize;
import pcb.model.ImageSize;

public class CommonTest {

	@Test
	public void testEncodeFile() throws IOException {
		byte[] expecteds = {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 
				72, 68, 82, 0, 0, 0, 1, 0, 0, 0, 1, 8, 2, 0, 0, 0, -112, 119,
				83, -34, 0, 0, 0, 1, 115, 82, 71, 66, 0, -82, -50, 28, -23, 0,
				0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0,
				0, 9, 112, 72, 89, 115, 0, 0, 14, -61, 0, 0, 14, -61, 1, -57,
				111, -88, 100, 0, 0, 0, 12, 73, 68, 65, 84, 24, 87, 99, 96, 96,
				96, 0, 0, 0, 4, 0, 1, 92, -51, -1, 105, 0, 0, 0, 0, 73, 69, 78, 
				68, -82, 66, 96, -126};
		byte[] actuals = Common.encodeFile(new File("res/OneBlackPixel.png"));
		Assert.assertArrayEquals(expecteds, actuals);
	}

	// Portrait 1 - High aspect ratio 
	
	@Test
	public void testCalculateNewSizePortrait1Small() {
		ImageSize originalSize = new ImageSize(1000, 4000);
		ImageSize modelSize = DefaultImageSize.SMALL.getSize();
		ImageSize newSize = Common.calculateNewSize(originalSize, modelSize);
		Assert.assertEquals(newSize.getHeight(), modelSize.getHeight());
	}
	
	// Portrait 2 - Low aspect ratio 
	
	@Test
	public void testCalculateNewSizePortrait2Medium() {
		ImageSize originalSize = new ImageSize(3500, 4000);
		ImageSize modelSize = DefaultImageSize.MEDIUM.getSize();
		ImageSize newSize = Common.calculateNewSize(originalSize, modelSize);
		Assert.assertEquals(newSize.getWidth(), modelSize.getWidth());
	}
	
	// Landscape 1 - High aspect ratio 
	
	@Test
	public void testCalculateNewSizeLandscapeLarge() {
		ImageSize originalSize = new ImageSize(4000, 1000);
		ImageSize modelSize = DefaultImageSize.LARGE.getSize();
		ImageSize newSize = Common.calculateNewSize(originalSize, modelSize);
		Assert.assertEquals(newSize.getWidth(), modelSize.getHeight());
	}
	
	// Landscape 2 - Low aspect ratio 
	
	@Test
	public void testCalculateNewSizeLandscape2Small() {
		ImageSize originalSize = new ImageSize(4000, 3500);
		ImageSize modelSize = DefaultImageSize.SMALL.getSize();
		ImageSize newSize = Common.calculateNewSize(originalSize, modelSize);
		Assert.assertEquals(newSize.getHeight(), modelSize.getWidth());
	}
	
	// Squared
	
	@Test
	public void testCalculateNewSizeSquared() {
		ImageSize originalSize = new ImageSize(4000, 4000);
		ImageSize newSize = null;
		
		for (DefaultImageSize modelSize : DefaultImageSize.values()) {
			newSize = Common.calculateNewSize(originalSize, modelSize.getSize());
			Assert.assertEquals(newSize.getWidth(), modelSize.getSize().getWidth());
			Assert.assertEquals(newSize.getHeight(), modelSize.getSize().getWidth());
		}
	}

}
