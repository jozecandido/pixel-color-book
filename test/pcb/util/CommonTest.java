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

	@Test
	public void testCalculateNewSizePortrait() {
		ImageSize originalSize = new ImageSize(1080, 1806);
		ImageSize size = Common.calculateNewSize(originalSize, DefaultImageSize.LARGE.getSize());
		Assert.assertEquals(size.getHeight(), DefaultImageSize.LARGE.getSize().getHeight());
	}
	
	@Test
	public void testCalculateNewSizeLandscape() {
		ImageSize originalSize = new ImageSize(1806, 1080);
		ImageSize size = Common.calculateNewSize(originalSize, DefaultImageSize.LARGE.getSize());
		Assert.assertEquals(size.getWidth(), DefaultImageSize.LARGE.getSize().getHeight());
	}

}
