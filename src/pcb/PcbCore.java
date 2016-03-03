package pcb;

import java.util.ArrayList;
import java.util.List;

public class PcbCore {

	public static void main(String[] args) {
		System.out.println("inicio");
						
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
	
	/**
	 * Returns list of pencils in the box of 12 color pencil box.
	 * @return
	 */
	public List<Pencil> create12ColorPencilBox() {

		List<Pencil> box = new ArrayList<Pencil>();

		box.add(new Pencil(5, "Amarelo Canário", 252, 226, 0));
		box.add(new Pencil(9, "Laranja", 243, 111, 33));
		box.add(new Pencil(17, "Rosa Chiclete", 242, 124, 162));
		box.add(new Pencil(21, "Vermelho", 218, 32, 40));
		box.add(new Pencil(32, "Rosa Claro", 247, 160, 139));
		box.add(new Pencil(34, "Carmim", 94, 47, 125));
		box.add(new Pencil(43, "Azul Cobalto", 5, 42, 108));
		box.add(new Pencil(47, "Azul", 0, 165, 228));
		box.add(new Pencil(63, "Verde", 0, 81, 44));
		box.add(new Pencil(70, "Verde Folha", 50, 165, 67));
		box.add(new Pencil(76, "Marrom", 76, 18, 0));
		box.add(new Pencil(99, "Preto", 0, 21, 34));
		
		return box;
	}
	
	/**
	 * Returns list of pencils in the box of 24 color pencil box.
	 * @return
	 */
	public List<Pencil> create24ColorPencilBox() {

		List<Pencil> box = new ArrayList<Pencil>();

		box.addAll(create12ColorPencilBox());
		box.add(new Pencil(1, "Branco", 255, 255, 255));
		box.add(new Pencil(13, "Laranja Claro", 243, 111, 33));
		box.add(new Pencil(27, "Vermelho Escuro", 140, 46, 69));
		box.add(new Pencil(29, "Vermelho Violeta", 178, 64, 121));
		box.add(new Pencil(37, "Violeta", 60, 48, 135));
		box.add(new Pencil(61, "Verde Água", 0, 173, 149));
		box.add(new Pencil(71, "Verde Claro", 111, 191, 84));
		box.add(new Pencil(74, "Verde Pinho", 85, 139, 57));
		box.add(new Pencil(89, "Canela", 115, 74, 56));
		box.add(new Pencil(91, "Bordô", 154, 64, 64));
		box.add(new Pencil(97, "Cinza Escuro", 83, 91, 97));
		box.add(new Pencil(696, "Prata", 167, 169, 171));
		
		return box;
	}
	
	/**
	 * Returns list of pencils in the box of 36 color pencil box.
	 * @return
	 */
	public List<Pencil> create36ColorPencilBox() {

		List<Pencil> box = new ArrayList<Pencil>();

		box.addAll(create24ColorPencilBox());
		box.add(new Pencil(7, "Amarelo", 255, 203, 4));
		box.add(new Pencil(15, "Laranja Escuro", 240, 80, 34));
		box.add(new Pencil(33, "Vinho", 146, 55, 87));
		box.add(new Pencil(46, "Azul Céu", 104, 146, 204));
		box.add(new Pencil(51, "Azul Turquesa", 0, 26, 75));
		box.add(new Pencil(55, "Verde Turquesa", 0, 115, 106));
		box.add(new Pencil(59, "Verde Escuro", 0, 54, 26));
		box.add(new Pencil(75, "Sépia", 44, 4, 0));
		box.add(new Pencil(77, "Marrom Escuro", 84, 43, 32));
		box.add(new Pencil(82, "Ocre", 163, 148, 70));
		box.add(new Pencil(83, "Marrom Claro", 185, 144, 50));
		box.add(new Pencil(604, "Ouro", 169, 145, 85));
		
		return box;
	}

}
