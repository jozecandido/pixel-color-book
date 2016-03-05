package pcb;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import pcb.exception.BoxSizeException;
import pcb.exception.NoPencilBrandException;
import pcb.imaging.ColorImageMapping;
import pcb.imaging.processor.ColorImageMappingProcessor;
import pcb.imaging.processor.ImageProcessor;
import pcb.model.ColorPencilBox;
import pcb.model.PaintSize;
import pcb.model.PencilBrand;
import pcb.model.factory.ColorPencilBoxFactory;
import pcb.util.Comon;
import pcb.util.ImageDisplay;

public class PcbCore {
	
	//DONE: Definir mapa de cores
	//DONE: Definir conjunto de lapis
	
	//INPUT
	//DONE: Receber arquivo imagem
	//DONE: Receber TAMANHO
	//DONE: Receber conjunto de lápis 
	
	//PRE-PROCESSAMENTO
	//TODO: processar stream?
	//TODO: Mudar contraste e saturação
	//DONE: redimensionar para tamanhos 
	
	//PROCESSAMENTO
	//TODO: ?? Traduzir mapa de cores para byte|rgb|o que for ??
	//TODO: Mapear pixels da imagem
	//TODO: Mapear pixel para lápis sqrt( (R1-R2)ˆ2 + (G1-G2)ˆ2 + (B1-B2)ˆ2) (implementado abaixo)
	//TODO: Gerar tabela mapeada
	
	//POS-PROCESSAMENTO | OUTPUT
	//DONE: Exibir imagem
	//TODO: Gerar PDF	
	
	public void createDrawing(File image, PaintSize paintSize, int boxSize, PencilBrand brand) {

		try {
			ColorPencilBox box = ColorPencilBoxFactory.createBox(boxSize, brand);
			ImageProcessor processor = ColorImageMappingProcessor.getCurrentProcessor();
			ColorImageMapping mapping = processor.processImage(Comon.encodeFile(image), box, paintSize);
			ColorImageMapping preview = processor.processImage(mapping.getResizedImage(), box, PaintSize.USER);
			ImageDisplay.displayImage(preview.getResizedImage());
			
		} catch (NoPencilBrandException e) {
			e.printStackTrace();
		} catch (BoxSizeException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("inicio");
		
		String pathImage = "res/sample2.jpg";
		String paintSize = "LARGE";
		String brand = "FaberCastell";
		String pencilBoxSize = "60";
		
		if(args != null) {
			switch(args.length) {
				case 4:
					pencilBoxSize = args[3];
				case 3:
					brand = args[2];
				case 2:
					paintSize = args[1];
				case 1: 
					pathImage = args[0];
				default:
					break;
			}
		}
		
		new PcbCore().createDrawing(new File(pathImage),
				PaintSize.valueOf(paintSize), 
				Integer.parseInt(pencilBoxSize),
				PencilBrand.valueOf(brand));
	}
}
