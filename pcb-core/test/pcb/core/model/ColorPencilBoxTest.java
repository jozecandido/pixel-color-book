package pcb.core.model;

import org.junit.Assert;
import org.junit.Test;

import pcb.core.exception.BoxSizeException;
import pcb.core.exception.NoPencilBrandException;
import pcb.core.model.ColorPencilBox;
import pcb.core.model.Pencil;
import pcb.core.model.PencilBrand;
import pcb.core.model.factory.ColorPencilBoxFactory;

public class ColorPencilBoxTest {

	@Test
	public void testcreate12ColorPencilBox() throws NoPencilBrandException, BoxSizeException {
		System.out.println("********* 12 Color Pencil Box *********");
		ColorPencilBox box = ColorPencilBoxFactory.createBox(12, PencilBrand.FaberCastell);
		for (Pencil pencil : box.getPencils()) {
			System.out.println(pencil.toString());
		}
		Assert.assertEquals(box.getSize(), 12);
	}
	
	@Test
	public void testcreate24ColorPencilBox() throws NoPencilBrandException, BoxSizeException {
		System.out.println("********* 24 Color Pencil Box *********");
		ColorPencilBox box = ColorPencilBoxFactory.createBox(24, PencilBrand.FaberCastell);
		for (Pencil pencil : box.getPencils()) {
			System.out.println(pencil.toString());
		}
		Assert.assertEquals(box.getSize(), 24);
	}

	@Test
	public void testcreate36ColorPencilBox() throws NoPencilBrandException, BoxSizeException {
		System.out.println("********* 36 Color Pencil Box *********");
		ColorPencilBox box = ColorPencilBoxFactory.createBox(36, PencilBrand.FaberCastell);
		for (Pencil pencil : box.getPencils()) {
			System.out.println(pencil.toString());
		}
		Assert.assertEquals(box.getSize(), 36);
	}
	
	@Test
	public void testcreate48ColorPencilBox() throws NoPencilBrandException, BoxSizeException {
		System.out.println("********* 48 Color Pencil Box *********");
		ColorPencilBox box = ColorPencilBoxFactory.createBox(48, PencilBrand.FaberCastell);
		for (Pencil pencil : box.getPencils()) {
			System.out.println(pencil.toString());
		}
		Assert.assertEquals(box.getSize(), 48);
	}
	
	@Test
	public void testcreate60ColorPencilBox() throws NoPencilBrandException, BoxSizeException {
		System.out.println("********* 60 Color Pencil Box *********");
		ColorPencilBox box = ColorPencilBoxFactory.createBox(60, PencilBrand.FaberCastell);
		for (Pencil pencil : box.getPencils()) {
			System.out.println(pencil.toString());
		}
		Assert.assertEquals(box.getSize(), 60);
	}
	
	@Test(expected=BoxSizeException.class)
	public void testthrowBoxSizeException() throws NoPencilBrandException, BoxSizeException {
		System.out.println("********* BoxSizeException *********");
		ColorPencilBox box = ColorPencilBoxFactory.createBox(72, PencilBrand.FaberCastell);
		Assert.assertEquals(box.getSize(), 60);
	}
	
	@Test(expected=NoPencilBrandException.class)
	public void testthrowNoPencilBrandException() throws NoPencilBrandException, BoxSizeException {
		System.out.println("********* NoPencilBrandException *********");
		ColorPencilBox box = ColorPencilBoxFactory.createBox(60, PencilBrand.NotDefined);
		Assert.assertEquals(box.getSize(), 60);
	}

}
