package pcb;

import java.util.List;

public class PcbCore {

	public static void main(String[] args) {
		System.out.println("inicio");
		
		// [DONE] Definir mapa de cores
		// [DONE] Definir conjunto de lapis
		List<Pencil> box60 = ColorPencilBox.create60ColorPencilBox();
		
		//INPUT
		//TODO: receber arquivo imagem
		//TODO: receber TAMANHO
		//TODO: receber conjunto de lápis 
		
		//PRE-PROCESSAMENTO
		//TODO: processar stream?
		//TODO: Mudar contraste e saturação
		//TODO: redimensionar para tamanhos (P,M e G:50px,72px)
		
		//PROCESSAMENTO
		//TODO: ?? Traduzir mapa de cores para byte|rgb|o que for ??
		//TODO: Mapear pixels da imagem
		//TODO: Mapear pixel para lápis sqrt( (R1-R2)ˆ2 + (G1-G2)ˆ2 + (B1-B2)ˆ2)  
		//TODO: Gerar tabela mapeada
		
		//POS-PROCESSAMENTO | OUTPUT
		//TODO: Gerar PDF		
	}
}
