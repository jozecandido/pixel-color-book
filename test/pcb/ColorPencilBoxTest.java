package pcb;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ColorPencilBoxTest {

	@Test
	public void testcreate12ColorPencilBox() {
		System.out.println("********* 12 Color Pencil Box *********");
		List<Pencil> box = ColorPencilBox.create12ColorPencilBox();
		for (Pencil pencil : box) {
			System.out.println(pencil.toString());
		}
		Assert.assertEquals(box.size(), 12);
	}
	
	@Test
	public void testcreate24ColorPencilBox() {
		System.out.println("********* 24 Color Pencil Box *********");
		List<Pencil> box = ColorPencilBox.create24ColorPencilBox();
		for (Pencil pencil : box) {
			System.out.println(pencil.toString());
		}
		Assert.assertEquals(box.size(), 24);
	}

	@Test
	public void testcreate36ColorPencilBox() {
		System.out.println("********* 36 Color Pencil Box *********");
		List<Pencil> box = ColorPencilBox.create36ColorPencilBox();
		for (Pencil pencil : box) {
			System.out.println(pencil.toString());
		}
		Assert.assertEquals(box.size(), 36);
	}
	
	@Test
	public void testcreate48ColorPencilBox() {
		System.out.println("********* 48 Color Pencil Box *********");
		List<Pencil> box = ColorPencilBox.create48ColorPencilBox();
		for (Pencil pencil : box) {
			System.out.println(pencil.toString());
		}
		Assert.assertEquals(box.size(), 48);
	}
	
	@Test
	public void testcreate60ColorPencilBox() {
		System.out.println("********* 60 Color Pencil Box *********");
		List<Pencil> box = ColorPencilBox.create60ColorPencilBox();
		for (Pencil pencil : box) {
			System.out.println(pencil.toString());
		}
		Assert.assertEquals(box.size(), 60);
	}

}
