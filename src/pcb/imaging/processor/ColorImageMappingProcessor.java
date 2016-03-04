package pcb.imaging.processor;

public final class ColorImageMappingProcessor {

	public static ImageProcessor getCurrentProcessor() {
		return System.getProperty("java.version") != "0" ? new JDKProcessor() : null;
	}
}
