package pcb.core;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pcb.core.model.DefaultImageSize;
import pcb.core.model.PencilBrand;

public class PcbCoreTest {

	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
	}

	@Test
	public void testImageSample1_LARGE_60_FaberCastell() throws InterruptedException {
		new PcbCore().createDrawing(
				new File("res/sample1.jpg"), DefaultImageSize.LARGE, 60, PencilBrand.FaberCastell);
	}

}
