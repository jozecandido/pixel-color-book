package pcb;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PcbCoreTest {

	private PcbCore core = null;
	
	@Before
	public void setUp() {
		core = new PcbCore();
	}
	
	@Test
	public void testcreate12ColorPencilBox() {
		List<Pencil> box = core.create12ColorPencilBox();
		for (Pencil pencil : box) {
			System.out.println(pencil.toString());
		}
		Assert.assertEquals(box.size(), 12);
	}
	
	@Test
	public void testcreate24ColorPencilBox() {
		List<Pencil> box = core.create24ColorPencilBox();
		for (Pencil pencil : box) {
			System.out.println(pencil.toString());
		}
		Assert.assertEquals(box.size(), 24);
	}

	
	@Test
	public void testcreate48ColorPencilBox() {
		List<Pencil> box = core.create48ColorPencilBox();
		for (Pencil pencil : box) {
			System.out.println(pencil.toString());
		}
		Assert.assertEquals(box.size(), 48);
	}
	
	@Test
	public void testcreate60ColorPencilBox() {
		List<Pencil> box = core.create60ColorPencilBox();
		for (Pencil pencil : box) {
			System.out.println(pencil.toString());
		}
		Assert.assertEquals(box.size(), 60);
	}

}
