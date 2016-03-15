package pcb.core.imaging.mapping;

import pcb.core.exception.PcbException;
import pcb.core.imaging.ColorImageMapping;
import pcb.core.imaging.MappedImage;
import pcb.core.model.ColorPencilBox;

public interface MappingProcessor {

	public MappedImage processMapping(ColorImageMapping map, ColorPencilBox box) throws PcbException ;
	
	public static MappingProcessor getCurrentProcessor() {
		return new JDKMappingProcessor();
	}
}
