package pcb.model.factory;

import pcb.exception.BoxSizeException;
import pcb.exception.NoPencilBrandException;
import pcb.model.ColorPencilBox;
import pcb.model.PencilBrand;

public final class ColorPencilBoxFactory {

	public static ColorPencilBox createBox(int size, PencilBrand brand) throws NoPencilBrandException, BoxSizeException {
		switch(brand) {
			case FaberCastell:
				return FaberCastellPencilBoxFactory.createColorPencilBox(size);
			default:
				throw new NoPencilBrandException();
		}
	}
}
