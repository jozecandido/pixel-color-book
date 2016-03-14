package pcb.imaging.mapping;

import pcb.exception.PcbException;
import pcb.imaging.ColorImageMapping;
import pcb.imaging.MappedImage;
import pcb.model.ColorPencilBox;

public interface MappingProcessor {

	public MappedImage processMapping(ColorImageMapping map, ColorPencilBox box) throws PcbException ;
	
	public static MappingProcessor getCurrentProcessor() {
		return new JDKMappingProcessor();
	}
}
