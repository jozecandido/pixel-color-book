package pcb.core.model.factory;

import pcb.core.exception.BoxSizeException;
import pcb.core.exception.NoPencilBrandException;
import pcb.core.model.ColorPencilBox;
import pcb.core.model.PencilBrand;

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
